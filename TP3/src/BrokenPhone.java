import java.math.BigInteger;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Rafael Gameiro (50677)
 * @author Rui Santos (50833)
 *
 */
public class BrokenPhone {

	public static final BigInteger DEFAULT_VAL = new BigInteger("-1");
	public static final BigInteger MODULE_POW = new BigInteger("" + (long) Math.pow(2, 45));

	int s, t;
	BigInteger N;
	int[] interfDegree;
	List<Integer>[] friendships;

	public BrokenPhone(int s, int t, int N, int[] interfDegree, List<Integer>[] friendships) {
		this.s = s;
		this.t = t;
		this.N = new BigInteger("" + N);
		this.interfDegree = interfDegree;
		this.friendships = friendships;
	}

	/**
	 * Computes the Dijkstra algorithm 
	 * Firstly, initialises the variables (selected, noise and connected) 
	 * and after that, it will set all the position of the
	 * noise array with the constant DEFAULT_VAL, except for the source's successors 
	 * The algorithm starts by taking the Pair(node, noise) object with the less noise
	 * and checks if the object is the target person 
	 * If it is not, the it will explore it's successors 
	 * After that returns the value of the noise
	 * 
	 * @return the noise of the person target after applying the module of 2^45
	 */
	public BigInteger dijkstra() {

		boolean[] selected = new boolean[friendships.length];
		BigInteger[] noise = new BigInteger[friendships.length];

		Queue<Pair> connected = new PriorityQueue<>();

		for (int i = 0; i < friendships.length; i++)
			noise[i] = DEFAULT_VAL;

		for (int node : friendships[s]) {
			BigInteger value = new BigInteger("0");
			noise[node] = value;
			connected.add(new Pair(node, value));
		}

		do {
			Pair pair = connected.remove();
			selected[pair.getKey()] = true;
			if (pair.getKey() == t)
				break;
			exploreNodes(pair, selected, noise, connected);

		} while (!connected.isEmpty());

		return noise[t].mod(MODULE_POW);
	}

	/**
	 * The method will run through all the node's successors and for each successor,
	 * it will check if that successor was already explored 
	 * If a successor is the target, it will set the newNoise value, 
	 * as the value in the noise array, node position 
	 * Checks if it's the first time computing the successor's noise or the
	 * newNoise value is less than the previous computed noise of the successor and
	 * if it is, replaces the value in the noise array and inserts the newNoise
	 * value in the priority queue
	 * 
	 * @param pair      current Pair object
	 * @param selected  array with the info of the explored nodes
	 * @param noise     array with the info of noise for each node
	 * @param connected priority queue with the nodes already explored
	 */
	private void exploreNodes(Pair pair, boolean[] selected, BigInteger[] noise, Queue<Pair> connected) {
		BigInteger newNoise = null;
		for (int node : friendships[pair.getKey()]) {
			if (!selected[node]) {
				newNoise = new BigInteger("" + interfDegree[pair.getKey()]);
				newNoise = newNoise.add(noise[pair.getKey()].multiply(N));

				if (noise[node].compareTo(DEFAULT_VAL) == 0 || newNoise.compareTo(noise[node]) == -1) {
					noise[node] = newNoise;
					connected.add(new Pair(node, newNoise));
				}
			}
		}
	}

}
