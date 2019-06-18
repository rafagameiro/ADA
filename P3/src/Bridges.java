import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author Rafael Gameiro n50677
 *
 */
public class Bridges {

	//tem dois valores por causa das duas margens
	private int[][] os;
	private int[][] values;
	private int osVal;
	
	private Map<String, Integer> valToOS;
	
	public Bridges () {
		os = new int[2][];
		values = new int[2][];
		osVal = 0;
		valToOS = new HashMap<String, Integer>();
	}
	
	public void setOsNorthSize(int size) {
		os[0] = new int[size];
	}
	
	public void setOsSouthSize(int size) {
		os[1] = new int[size];
	}
	
	public void setValueNorthSize(int size) {
		values[0] = new int[size];
	}
	
	public void setValueSouthSize(int size) {
		values[1] = new int[size];

	}
 	
	public void addNorthCity(String name, String os, int value, int index) {
		Integer val = valToOS.get(os);
		if(val == null) {
			valToOS.put(os, osVal);
			this.os[0][index] = osVal++;
		} else
			this.os[0][index] = val;
		
		values[0][index] = value;			
	}
	
	public void addSouthCity(String name, String os, int value, int index) {
		Integer val = valToOS.get(os);
		if(val == null) {
			valToOS.put(os, osVal);
			this.os[1][index] = osVal++;
		} else
			this.os[1][index] = val;
		
		values[1][index] = value;	
	}
	
	
	//Debugging
	public void printOS() {
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < os[i].length; j++)
				System.out.println(os[i][j]);
	}
	
	public void printValue() {
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < values[i].length; j++)
				System.out.println(values[i][j]);
	}
	
	public void printMap() {
		Set<String> ka = valToOS.keySet();
		for (String v : ka) {
			System.out.println(v);
		}
			
	}
	
}
