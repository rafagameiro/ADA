import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author Rafael Gameiro n50677
 *
 */
public class escapingZombies {
	
	public escapingZombies() {
		
	}

	public int determinePath(boolean root) {
		int minPath = -1;
		Queue <Boolean> q = new LinkedList<Boolean>();
		int depth = 0;
		q.add(root);
		do {
			int cursor = q.size();
			for(int i = 0; i < cursor; i++)
				System.out.println("TODO");
			depth++;
		} while(!q.isEmpty());
		
		
		return minPath;
	}
}
