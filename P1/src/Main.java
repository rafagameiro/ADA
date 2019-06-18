import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author Rafael Gameiro n50677
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int numOfChildren = 1;

		numOfChildren = Integer.parseInt(br.readLine());

		String[] childrenData = new String[numOfChildren];
		int highestNum = Integer.MIN_VALUE;

		for(int i = 0; i < numOfChildren; i++) {
			childrenData[i] = br.readLine();
			String[] sticks = childrenData[i].split(" ");
			for(int j = 0; j < sticks.length-1; j++) {
				int currStick = Integer.parseInt(sticks[j+1]);
				if(highestNum < currStick)
					highestNum = currStick;
			}

		}

		System.out.println(highestNum);


	}

}
