import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Gregory Evevsky
 * TODO
 */
public abstract class SelectorSuper extends JPanel {

	protected ArrayList<String> pressed;
	
	public enum Rank{  
		ACE,TWO,THREE,FOUR, FIVE, SIX, SEVEN,EIGHT, NINE,TEN,JACK,KING,QUEEN
	}

	public enum Suite{
		CLUBS, DIAMONDS, HEARTS, SPADES
	}
	
	public SelectorSuper(){
		pressed = new ArrayList<String>();
	}
	abstract public Card[] getSelected() ;
		
	
	
	/**
	 * changes x from an int to a string resembling the rank
	 * ie: 1 returns "A"for ACE
	 * @param x
	 * @return
	 */
	protected String intRankToString(int x) {
		switch (x) {
		case 14:
			return "A";
		case 10: 
			return "T";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13: 
			return "K";
		default: 
			return Integer.toString(x);
		}
	}
	

	/**
	 * returns The letter representing the Suite
	 * C for clubs
	 * D for diamonds
	 * H for hearts
	 * S for spades
	 * @param s
	 * @return
	 */
	protected String suiteToString( Suite s) {
		switch (s) {
		case CLUBS:
			return "C";
		case DIAMONDS:
			return "D";
		case HEARTS:
			return "H";
		case SPADES:
			return "S";
		default:
			return "could not convert suite To String";
		}
	}

	protected Suite intToSuite(int s) {
		switch(s) {
		case 0: 
			return Suite.CLUBS;
		case 1:    
			return Suite.DIAMONDS;
		case 2:    
			return Suite.HEARTS;
		case 3:    
			return Suite.SPADES;
		default:
				return null;
		}
	}
	
	/**
	 * converts r to a string
	 * IE Rank.TWO returns "2"
	 * @param r
	 * @return
	 */
	protected String rankToString( Rank r) {
		switch(r) {
		case TWO:
			return "2";
		case ACE:
			return "A" ;
		case EIGHT:
			return "8" ;
		case FIVE:
			return "5" ;
		case FOUR:
			return "4" ;
		case JACK:
			return "J" ;
		case KING:
			return "K" ;
		case NINE:
			return "9" ;
		case QUEEN:
			return "Q" ;
		case SEVEN:
			return "7" ;
		case SIX:
			return "6" ;
		case TEN:
			return "T" ;
		case THREE:
			return "3" ;
		default:
			return " " ;
			
		}
	}
	
	protected int stringToIntRank(String r) {
		if(r.equals("2")) {
			return 2;
		}if(r.equals("3")) {
			return 3;
		}if(r.equals("4")) {
			return 4;
		}if(r.equals("5")) {
			return 5;
		}if(r.equals("6")) {
			return 6;
		}if(r.equals("7")) {
			return 7;
		}if(r.equals("8")) {
			return 8;
		}if(r.equals("9")) {
			return 9;
		}if(r.equals("T") || r.equals("t")) {
			return 10;
		}if(r.equals("J") || r.equals("j")) {
			return 11;
		}if(r.equals("Q") || r.equals("q")) {
			return 12;
		}if(r.equals("K") || r.equals("k")) {
			return 13;
		}if(r.equals("A") || r.equals("a")) {
			return 1;
		}
		return 0;
	}
	/**
	 * @return the pressed toggle buttons
	 */
	public ArrayList<String> getPressed() {
		return pressed;
	}


	
}
