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
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nSamples = Integer.parseInt(br.readLine());
		
		int nNorth = 0;
		int nSouth = 0;
		Bridges b = new Bridges();
		
		for(int i = 0; i < nSamples; i++) {
			nNorth = Integer.parseInt(br.readLine());
			addNorth(br, nNorth, b);
			nSouth = Integer.parseInt(br.readLine());
			addSouth(br, nSouth, b);
		}
		
		b.printMap();

	}

	private static void addNorth(BufferedReader br, int nNorth, Bridges b) throws IOException {
		// TODO Auto-generated method stub
		b.setOsNorthSize(nNorth);
		b.setValueNorthSize(nNorth);
		for(int i = 0; i < nNorth; i++) {
			String[] line = br.readLine().split(" ");
			b.addNorthCity(line[0], line[1], Integer.parseInt(line[2]), i);
		}
			
	}
	
	private static void addSouth(BufferedReader br, int nSouth, Bridges b) throws IOException {
		// TODO Auto-generated method stub
		b.setOsSouthSize(nSouth);
		b.setValueSouthSize(nSouth);
		for(int i = 0; i < nSouth; i++) {
			String[] line = br.readLine().split(" ");
			b.addSouthCity(line[0], line[1], Integer.parseInt(line[2]), i);
		}
			
	}

}
