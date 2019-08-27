

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
	
	@Override
	public String toString() {
		String r = "";
		if(rank == 1) {
			r = "A";
		}else if(rank == 10) {
			r ="T";
		}else if(rank == 11) {
			r = "J";
		}else if(rank == 12) {
			r = "Q";
		}else if(rank == 13) {
			r = "K";
		}else {
			return "" + rank + suite;
		}
		return r  + suite;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			Card that = (Card)obj;
			return that.getRank() == this.getRank() && that.getSuite() == this.getSuite();
		}
		return false;
	}
	

}
