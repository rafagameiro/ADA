/**
 * 
 */
package solver;

/**
 * @author Rafael Gameiro n50677
 *
 */
public class LegoMosaics {
	
	private int[] bricks = {1, 2, 3, 4, 6, 8, 10, 12, 16};
	private int[] colRowLen;
	private int sizeofCombinations;
	
	public LegoMosaics(int size) {
		colRowLen = new int[size];
		sizeofCombinations = 0;
	}
	
	public void processLine(char[] line) {
		char prevChar = line[0];
		int charCount = 1;
		for(int i = 1; i < line.length; i++, charCount++) {
			if(prevChar != line[i]) {
				if(prevChar != '.') {
					if(colRowLen[charCount] == 0)
						sizeofCombinations++;
					colRowLen[charCount]++;
				}
				charCount = 0;
				prevChar = line[i];
			}	
		}
		if(charCount != 0 && line[line.length-1] != '.') {
			if(colRowLen[charCount] == 0)
				sizeofCombinations++;
			colRowLen[charCount]++;
		}
		
	}
	
	public int computeCombinations() {
		int[] combinations = new int[sizeofCombinations + 1];
		
		combinations[0] = 1;
		for(int i = 0; i < combinations.length; i++)
			for(int j = 0; j < bricks.length && bricks[j] <= i; j++)
				combinations[i] += combinations[ i - bricks[j]];
		System.out.println(combinations[0]);
		int res = 1;
		for(int i = 1; i < combinations.length; i++)
			res *= Math.pow(combinations[i], colRowLen[i]);
		
		return res;
	}
	
	public void print(int[] arrayToPrint) {
		System.out.println("start");
		for(int i = 0; i < arrayToPrint.length; i++)
			System.out.println(arrayToPrint[i]);
	}
	

}
