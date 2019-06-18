import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import solver.LegoMosaics;

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
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String[] colsAndRows = br.readLine().split(" ");
		int rows = Integer.parseInt(colsAndRows[0]);
		int cols = Integer.parseInt(colsAndRows[1]);
		
		LegoMosaics lego = new LegoMosaics(cols + 1);
		for(int i = 0; i < rows; i++) {
			String currLine = br.readLine();
			lego.processLine(currLine.toCharArray());
		}

		int result = lego.computeCombinations();
		System.out.println(result);

	}

}
