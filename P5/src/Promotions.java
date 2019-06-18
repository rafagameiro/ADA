import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Rafael Gameiro n50677
 *
 */
public class Promotions {

	private int min;
	private int max;
	private List<Integer>[] emplPromot;
	private int[] successors;
	private int[] anteccessors;

	public Promotions(int min, int max, int nEmployees) {
		this.min = min;
		this.max = max;
		successors = new int[nEmployees];
		anteccessors = new int[nEmployees];
		createDataStructure(nEmployees);
	}

	public void addSucessor(int employee, int outPerformed) {
		// TODO Auto-generated method stub
		emplPromot[employee].add(outPerformed);
	}

	public int[] showPromoted() {

		int[] solution = new int[3];
		bfsTransversal();
		
		

		return solution;
	}

	@SuppressWarnings("unchecked")
	private void createDataStructure(int nEmployees) {
		// TODO Auto-generated method stub
		emplPromot = new List[nEmployees];
		for (int i = 0; i < nEmployees; i++)
			emplPromot[i] = new LinkedList<>();
	}

	private void bfsTransversal() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < emplPromot.length; i++)
			bfsExplore(emplPromot[i], i);
	}

	private void bfsExplore(List<Integer> list, int currEmployee) {
		// TODO Auto-generated method stub
		boolean[] found = new boolean[emplPromot.length];
		Stack<Integer> waiting = new Stack<>();
		waiting.push(currEmployee);
		found[currEmployee] = true;
		
		do {
			int employee = waiting.pop();
			for (Integer i : emplPromot[employee]) {
				if(!found[i]) {
					successors[currEmployee]++;
					anteccessors[i]++;
					waiting.push(i);
					found[i] = true;
				}
			}
			
		} while( !waiting.isEmpty());
			
	}
	
	////////////////////DEBUG///////////////////////////////////////
	
	public void printSuc() {
		for(int i = 0; i < successors.length; i++)
			System.out.println(successors[i]);
	}
	
	public void printAnt() {
		for(int i = 0; i < anteccessors.length; i++)
			System.out.println(anteccessors[i]);
	}

}
