import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputNT = br.readLine();
		String[] inputNTArray = inputNT.split(" ");
		int nodes = Integer.parseInt(inputNTArray[0]);
		int tasks = Integer.parseInt(inputNTArray[1]);

		List<Edge>[] nodesSuc = new List[nodes];
		for (int i = 0; i < nodes; i++) {
			nodesSuc[i] = new LinkedList<>();
		}

		List<Integer>[] nodesAnt = new List[nodes];
		for (int i = 0; i < nodes; i++) {
			nodesAnt[i] = new LinkedList<>();
		}

		List<Node> nodesGraph = new ArrayList<Node>(nodes);

		int counter = 0;
		while (counter < tasks) {
			String input = br.readLine();
			String[] inputArray = input.split(" ");
			int nodeInicial = Integer.parseInt(inputArray[0]);
			int nodeFinal = Integer.parseInt(inputArray[1]);
			int duration = Integer.parseInt(inputArray[2]);

			Edge e = new Edge(nodeInicial - 1, nodeFinal - 1, duration);

			nodesSuc[nodeInicial - 1].add(e);
			nodesAnt[nodeFinal - 1].add(nodeInicial - 1);

			counter++;
		}

		int makingGraph = 0;
		while (makingGraph < nodes) {
			Node n = new Node(makingGraph, nodesSuc[makingGraph], nodesAnt[makingGraph]);
			nodesGraph.add(makingGraph, n);
			makingGraph++;
		}

		Graph g = new Graph(nodesGraph);

		UnderControl uc = new UnderControl(g);
		List<Edge> delays = uc.ordTopologic();

		System.out.println(delays.size());
		for (Edge edge : delays) {
			System.out.println((edge.returnStartNode() + 1) + " " + (edge.returnEndNode() + 1));
		}
	}

}
