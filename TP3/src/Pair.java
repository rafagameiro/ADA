import java.math.BigInteger;

/**
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class Pair implements Comparable<Pair>{
	
	private int key;
	private BigInteger value;
	
	public Pair(int key, BigInteger value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * 
	 * @return the number that corresponds to a person
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * 
	 * @return the current value of noise reaching this person
	 */
	public BigInteger getValue() {
		return value;
	}

	@Override
	public int compareTo(Pair pair) {
		return this.getValue().compareTo(pair.getValue());
	}

}
