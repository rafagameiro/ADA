import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class UnderControl {

	private Graph graph;

	public UnderControl(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Executes the topological sort algorithm.
	 * Before inserting the next node to be processed in the ready queue,
	 * the method exploreDelays will compute the maximum path cost to reach that node.
	 */
	public List<Edge> ordTopologic() {

		Comparator<Edge> comparatorEdges = new EdgeComparator();
		List<Edge> delays = new LinkedList<>();

		Queue<Node> ready = new LinkedList<>();

		int[] inDegree = new int[graph.numNodesInGraph()];
		int[] maxLength = new int[graph.numNodesInGraph()];

		for (Node node : graph.returnNodes()) {
			int pos = node.getState();
			inDegree[pos] = node.numAnt();
			if (inDegree[pos] == 0)
				ready.add(node);
		}

		do {
			Node node = ready.remove();
			for (Edge e : node.returnSuc()) {
				int pos = e.returnEndNode();
				inDegree[pos]--;
				if (inDegree[pos] == 0) {
					Node n = graph.returnNode(pos);
					exploreDelays(n, node, maxLength, delays);
					ready.add(n);
				}

			}

		} while (!ready.isEmpty());

		delays.sort(comparatorEdges);
		return delays;
	}

	/***
	 * Computes the maximum path cost to reach the Node current, 
	 * through the sum of the maximum path cost to reach Node antecessor plus the cost of the edge (antecessor -> current).
	 * If the current node has more than one antecessor, it will go through all its antecessors and compute the maximum path.
	 * The biggest cost will be the final maximum cost of the node, 
	 * while the other edges formed by the node and the other antecessors will be inserted in the delay queue.
	 * 
	 * @param current node that is going to be processed
	 * @param antecessor the previous node before the current node
	 * @param maxLength array with all the maximum path costs to reach each node
	 * @param delays list with all the edges that can be delayed 
	 */
	private void exploreDelays(Node current, Node antecessor, int[] maxLength, List<Edge> delays) {

		for (Edge edge : antecessor.returnSuc()) {
			if (edge.returnEndNode() != current.getState())
				continue;

			int nlength = maxLength[antecessor.getState()] + edge.returnDuration();
			maxLength[current.getState()] = nlength;
		}

		for (int ant : current.returnAnt()) {
			Node node = graph.returnNode(ant);
			for (Edge edge : node.returnSuc()) {
				if (edge.returnEndNode() != current.getState())
					continue;

				int nlength = maxLength[ant] + edge.returnDuration();

				if (maxLength[current.getState()] < nlength) {
					maxLength[current.getState()] = nlength;
				} else if (maxLength[current.getState()] > nlength) {
					delays.add(edge);
				}

			}
		}

	}

}
