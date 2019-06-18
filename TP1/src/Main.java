import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Rafael Gameiro n50677
 * @author Rui Santos n50833
 *
 */
public class Main {

	private static final char SEA = '.';

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputRC = br.readLine();
		String[] inputRCArray = inputRC.split(" ");
		int row = Integer.parseInt(inputRCArray[0]);
		int col = Integer.parseInt(inputRCArray[1]);
				
		String inputBS = br.readLine();
		String[] inputBSArray = inputBS.split(" ");
		int bridges = Integer.parseInt(inputBSArray[0]);
		int minSpaces = Integer.parseInt(inputBSArray[1]);
		
		Bridges b = new Bridges(row, col, bridges, minSpaces);

		/**
		* Processes a line from the map inputed by the user.
	 	* For every '.' char, a specific position in the nBridges array is increased by 1.
		*/
		int[] nBridges = new int[col];
		for(int i = 0; i < row ; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < line.length; j++) {
				if (line[j] == SEA)
					nBridges[j]++;
			}
		}

		br.close();	
		b.matrixNBridges(nBridges);

		System.out.println(b.solve());
				
	}

}
