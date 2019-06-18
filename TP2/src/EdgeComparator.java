import java.util.Comparator;

/**
 * 
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {

		if (e1.returnStartNode() == e2.returnStartNode()) {
			if (e1.returnEndNode() < e2.returnEndNode())
				return -1;
			else
				return 1;
		} else {
			if (e1.returnStartNode() < e2.returnStartNode())
				return -1;
			else
				return 1;
		}
	}

}
