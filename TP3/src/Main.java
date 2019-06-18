import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputArray = input.split(" ");
		int P = Integer.parseInt(inputArray[0]);
		int s = Integer.parseInt(inputArray[1]);
		int t = Integer.parseInt(inputArray[2]);
		int N = Integer.parseInt(inputArray[3]);
		
		int[] interfDegree = new int[P];
		List<Integer>[] friendships = new List[P];
		
		for(int i = 0 ; i < P ; i++) {
			int degree = Integer.parseInt(br.readLine());
			interfDegree[i] = degree;
			friendships[i] = new LinkedList<>();
		}
		
		int nFriendships = Integer.parseInt(br.readLine());
		for(int i = 0; i < nFriendships; i++) {
			input = br.readLine();
			inputArray = input.split(" ");
			int x = Integer.parseInt(inputArray[0]);
			int y = Integer.parseInt(inputArray[1]);
			friendships[x].add(y);
			friendships[y].add(x);
		}	
		
		BrokenPhone bp = new BrokenPhone(s,t,N,interfDegree,friendships);
		BigInteger result = bp.dijkstra();
		System.out.println(result);		
		
	}
}
