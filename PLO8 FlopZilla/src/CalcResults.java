import java.util.ArrayList;

/**
 * @author Gregory Evevsky
 * TODO Implement class
 */
public final  class CalcResults {

	private static final int TOTAL_FLOPS = 19600; // total different number of 3 card combos that can be made with a deck of cards

	
	public static void calcResults(Card[] hand, Card[] board, ResultsPane update) {

		if(board.length == 3) {
			update.updateTable(flopResults( hand, board), null);
		}else if(board.length == 4) {
			update.updateTable(turnResults(hand, board), null);
		}else if(board.length == 5) {
			update.updateTable(riverResults(hand, board), null);
		}else if(board.length == 0) {
			update.updateTable(preFlopResults(hand, board), null);
		}else {
			System.out.println("not enough info to calc results");
		}
	
	}

	
	private static Object[][] riverResults  (Card[] hand, Card[] board){return null;}
	private static Object[][] preFlopResults(Card[] hand, Card[] board){return null;}
	private static Object[][] turnResults   (Card[] hand, Card[] board){return null;}
	private static Object[][] flopResults   (Card[] hand, Card[] board){return null;}
	private static boolean hasNutFLushDraw (Card[] hand, Card[] board) {return false;}
	private static boolean hasNutLowDraw   (Card[] hand, Card[] board) {return false;}
	
	/**
	 * returns true if all conditions are met: 
	 *  	+ there are at least 2 unique low cards in the player hand
	 *  	+ 2 or more unique low cards are on the board.
	 *  	+ if there are only 2 low cards in the players hand:
	 *  		- no low card in the players hand can match the card on the board
	 *  	+ if the player has 3 low cards in their hand: 
	 *  		- 2 of the 3 low cards in the player's hand cannot match rank of the low cards on the board
	 *  	+ if the player has 4 low cards in their hand: 
	 *  		- at lease 2 of the low cards on the board cannot be the same rank as the player
	 * 
	 * @param hand
	 * @param board
	 * @return
	 */
	private static boolean hasAnyNutLowDraw(Card[] hand, Card[] board) {
		int boardLowCards = numberOfLowCards(board);
		if(boardLowCards < 2) {
			return false;
		}
		Card[] lowHand = getLowCards(hand);
		Card[] lowBoard = getLowCards(board);
		int handLowCards = numberOfLowCards(hand);
		// if 
		switch(handLowCards) {
		case 2: 
		case 3:
		case 4:
		
		}
		
		return false;
	}
	/**
	 * returns the low cards in a set
	 * @param c
	 * @return
	 */
	private static Card[] getLowCards(Card[] c) {
		ArrayList<Card> giveArrayList = new ArrayList<Card>();
		for(Card i : c) {
			if(i.getRank() <= 8 ) {
				giveArrayList.add(i);
			}
		}
		Card[] give = new Card[giveArrayList.size()];
		for( int i= 0; i < giveArrayList.size(); i++) {
			give[i] = giveArrayList.get(i);
		}
		return give;
		
	}
	/**
	 * counts the number of unique low cards in c
	 * @param c
	 * @return
	 */
	private static int numberOfLowCards(Card[] c) {
		ArrayList<Card> counted = new ArrayList<Card>();
		int give =0; 
		for(Card i: c) {
			// if card is a low card
			if(i.getRank() <= 8) {
				// check if we have counted that card before
				boolean flag = true;
				for( Card x: counted) {
					if(i.getRank() == x.getRank()) {
						flag = false;
						break;
					}
				}
				if(flag) {
					counted.add(i);
					give++;
				}
			}
		}
		return give;
	}
	
	private static boolean hasStr8Draw(Card[] hand, Card[] board) {return false;}
	
	/** 
	 * checks if a card in the hand matches a card on the board
	 * @param hand
	 * @param board
	 * @return
	 */
	private static boolean hasPair (Card[] hand, Card[] board) {
		for(Card x : hand) {
			for(Card y : board) {
				if(x.getRank() == y.getRank()){
					return true;
				}
			}
		}
		return false;
	}
	
	
}
