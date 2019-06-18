import java.util.List;

/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Node {

	private int state;
	private List<Edge> successors;
	private List<Integer> antecessors;

	public Node(int state, List<Edge> successors, List<Integer> antecessors) {
		this.state = state;
		this.successors = successors;
		this.antecessors = antecessors;
	}

	/**
	 * 
	 * @return the state (number) of the respective node
	 */
	public int getState() {
		return state;
	}

	/***
	 * 
	 * @return the successors of the respective node
	 */
	public List<Edge> returnSuc() {
		return successors;
	}

	/***
	 * 
	 * @return the antecessors of the respective node
	 */
	public List<Integer> returnAnt() {
		return antecessors;
	}

	/***
	 * 
	 * @return the number of antecessors of the respective node
	 */
	public int numAnt() {
		return antecessors.size();
	}
}
