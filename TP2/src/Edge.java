
/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Edge {

	private int startNode;
	private int endNode;
	private int duration;

	public Edge(int startNode, int endNode, int duration) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.duration = duration;
	}

	/***
	 * 
	 * @return the startNode of the respective Edge
	 */
	public int returnStartNode() {
		return startNode;
	}

	/***
	 * 
	 * @return the endNode of the respective Edge
	 */
	public int returnEndNode() {
		return endNode;
	}

	/***
	 * 
	 * @return the duration (cost) of the respective Edge
	 */
	public int returnDuration() {
		return duration;
	}
}
