import java.io.BufferedReader;
import java.io.IOException;
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initInput = br.readLine().split(" ");
		
		int minInterval = Integer.parseInt(initInput[0]);
		int maxInterval = Integer.parseInt(initInput[1]);
		int nEmployees = Integer.parseInt(initInput[2]);
		int nPrecedence = Integer.parseInt(initInput[3]);
		
		Promotions p = new Promotions(minInterval, maxInterval, nEmployees);
		
		for(int i = 0; i < nPrecedence; i++) {
			String[] outPerformed = br.readLine().split(" ");
			p.addSucessor(Integer.parseInt(outPerformed[0]), Integer.parseInt(outPerformed[1]));
		}
		
		int[] solution = p.showPromoted();

		for(int i = 0; i < solution.length; i++)
			System.out.println(solution[i]);
	}

}
