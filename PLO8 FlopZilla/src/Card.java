

/**
 * @author Gregory Evevsky
 * helper class to help make sence of the stats
 */
public class Card {

	private int rank; 
	private char suite;
	/**
	 * @param rank should be between 1 and 14
	 * @param suite
	 */
	public Card(int rank, char suite) {
		super();
		this.rank = rank;
		this.suite = suite;
	}
	

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @return the suite
	 */
	public char getSuite() {
		return suite;
	}  
	
	
}
