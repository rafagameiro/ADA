import java.util.List;

/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Graph {

	private List<Node> nodesGraph;

	public Graph(List<Node> nodesGraph) {
		this.nodesGraph = nodesGraph;
	}

	/***
	 * 
	 * @return the nodes that represent the Graph
	 */
	public List<Node> returnNodes() {
		return nodesGraph;
	}

	/***
	 * 
	 * @param position
	 * @return a specific node from the graph
	 */
	public Node returnNode(int position) {
		return nodesGraph.get(position);
	}

	/***
	 * 
	 * @return the number of nodes that represent the Graph
	 */
	public int numNodesInGraph() {
		return nodesGraph.size();
	}
}
