/**
 * 
 */

/**
 * @author Rafael Gameiro n50677
 * @author Rui Santos n50833
 *
 */
public class Bridges {

	int row;
	int col;
	int bridges;
	int space;
	int[] nBridges;

	public Bridges(int row, int col, int bridges, int space) {
		this.row = row;
		this.col = col;
		this.bridges = bridges;
		this.space = space;
		nBridges = new int[col];
	}

	/**
	 * Receives an array with the bridge size for each column.
	 */
	public void matrixNBridges(int[] array) {
		nBridges = array;
	}

	/**
	 * Computes the minimum cost to build a specific numbers of bridges within j columns.
	 * Initially fills the second row of the matrix, and after that computes the remaining rows,
	 * based on the values in the previous row.
	 * 
	 * @return the minimum cost to the number of bridges requested by the user, 
	 * 		   with a specific number of columns
	 */
	public int solve() {
		int[][] minVal = new int[bridges + 1][col];

		minVal[1][0] = nBridges[0];
		for (int j = 1; j < col; j++)
			minVal[1][j] = Math.min(nBridges[j], minVal[1][j - 1]);

		for (int i = 2; i < bridges + 1; i++) {
			int aux = (i - 1) * (space + 1);
			for (int j = aux; j < col; j++) {
				if (j == aux)
					minVal[i][j] = minVal[i - 1][j - space - 1] + nBridges[j];
				else if (j > i) {
					minVal[i][j] = Math.min(minVal[i][j - 1], minVal[i - 1][j - space - 1] + nBridges[j]);
				}
			}
		}

		return minVal[bridges][col - 1];
	}

}
