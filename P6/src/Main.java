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
	
	static final char WALL = '#';
	static final char POISON = 'P';
	static final char START = 'S';
	static final char END = 'E';
	static final char PATH = '.';
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initInput = br.readLine().split(" ");
		
		int l = Integer.parseInt(initInput[0]);
		int c = Integer.parseInt(initInput[1]);
		
		boolean[] map = new boolean[l*c];
		System.out.println(map.length);
		int startPos, finishPos, poisonPos = -1;
		
		for(int i = 0; i < l; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < c; j++)
				if(line[j] == START || line[j] == END || line[j] == PATH) {
					map[i*(l+1) + j] = true;
					if(line[j] == START)
						startPos = i*(l+1) + j;
					else if(line[j] == END)
						finishPos = i*(l+1) + j;
				}else {
					if(line[j] == POISON)
						poisonPos = i*(l+1) + j;				
				}					
		}
		
		int j = 1;
		for(int i = 0; i < map.length; i++) {
			if(i == j*l) {
				System.out.println(map[i]);
				j++;
			}
			else
				System.out.print(map[i] + " ");
		}
				
	}

}
