import java.util.ArrayList;

/**
 * @author Gregory Evevsky
 * TODO Implement class
 */
public final  class CalcResults {

	private static final int TOTAL_FLOPS = 19600; // total different number of 3 card combos that can be made with a deck of cards
	private static final int CARDS_IN_DECK = 52;

	private CardSelector board;
	private CardSelector hand;
	private ResultsPane rp;
	
	public CalcResults(CardSelector board, CardSelector hand , ResultsPane rp) {
		this.board = board;
		this.hand = hand;
		this.rp = rp;
	}
	
	public void calcResults() {
		if( hand.getSelected() != null  && hand.getSelected().length == 4) {
			calcResults(hand.getSelected(), board.getSelected(), rp);
		}else {
			System.out.println("calc results did not run, awaitnig more info");
		}
	}
	
	public static void calcResults(Card[] hand, Card[] board, ResultsPane update) {
		Object[][] results = new Object [2][2];
		results[0][0] = "the length of hand is :" + hand.length;
		results[1][1] = "i am also testing";
		String[] test = new String[2];
		test[0] = "this is a test";
		test[1] = "this is also a test";
		update.updateTable(results , test);
		if(board.length == 3) {
			update.updateTable(flopResults( hand, board), test);
		}
		else if(board.length == 4) {
			update.updateTable(turnResults(hand, board), test);
		}
//		}else if(board.length == 5) {
//			update.updateTable(riverResults(hand, board), null);
//		}else if(board.length == 0) {
//			update.updateTable(preFlopResults(hand, board), null);
//		}else {
//			System.out.println("not enough info to calc results");
//		}
	
	}

	
	private static Object[][] riverResults  (Card[] hand, Card[] board){return null;}
	
	
	private static Object[][] preFlopResults(Card[] hand, Card[] board){return null;}
	
	
	private static Object[][] turnResults   (Card[] hand, Card[] board){

		Object[][] give = new Object[4][2];
		String add = "";
		for(Card i : hand) {
			add += i;
			add += " , ";
		}
		give[0][0] = "the hand is";
		give[0][1] = add;
		add = "";
		for(Card i : board) {
			add += i;
			add += " , ";
		}
		give[1][0] = "the board is";
		give[1][1] = add;
		give[2][0] = "has low draw?";
		give[2][1] = new Boolean(hasLowDraw(hand, board));
		give[3][0] = "odds of compleating the low: ";
		give[3][1] = oddsOfMakeingLow(hand, board);
		return give;
		
	}
	
	/**
	 * flop results I want:
	 * 		+ has a low draw
	 * 		+ has a Str8 Draw
	 *		+ has a pair
	 * 		+ has two pair
	 * 		+ has 3 of a kind
	 * 
	 * 		+ how often will a low be made
	 * 
	 * @param hand
	 * @param board
	 * @return
	 */
	private static Object[][] flopResults   (Card[] hand, Card[] board){
		Object[][] give = new Object[4][2];
		String add = "";
		for(Card i : hand) {
			add += i;
			add += " , ";
		}
		give[0][0] = "the hand is";
		give[0][1] = add;
		add = "";
		for(Card i : board) {
			add += i;
			add += " , ";
		}
		give[1][0] = "the board is";
		give[1][1] = add;
		give[2][0] = "has low draw?";
		give[2][1] = new Boolean(hasLowDraw(hand, board));
		give[3][0] = "odds of compleating the low: ";
		give[3][1] = oddsOfMakeingLow(hand, board);
		return give;
	}
	/**
	 * 
	 * @param hand
	 * @param board
	 * @return
	 */
	private static double oddsOfMakeingLow(Card[]hand , Card[]board) {
		int cardsLeftToCome =  5 - board.length;
		Card[] lowBoard = getLowCards(board);
		Card[] lowHand = getLowCards(hand);

		// find how many cards make us a low
		int outs = 0; 
		
		// get rid of all pair low cards on the board 
		for( Card i :lowHand) {
			lowBoard = removeCardOfRank(i.getRank(), lowBoard);
		}

		if(lowBoard.length >= 3 && lowHand.length >= 2) {
			// we have made a low
			System.out.println("we have made a low");
			return 1;
		}

		// figure out how many outs we have if there are 2 low cards on the board and how many low cards are in our hand
		switch (lowHand.length) {
		case 1: // if there is only one card in our hand, we cannot make a low
			return 0;
		case 2: 
			outs = 16;
			break;
		case 3: 
			outs = 21;
			break;
		case 4:
			outs = 20;
		}
		if(lowBoard.length == 2) {
			// divide the number outs by how many cards are left in the deck
			if(cardsLeftToCome == 1) {
				return (double)outs /(double)(CARDS_IN_DECK - 4.0 -4.0); // 4 cards on board, 4 cards in hand
			}else if(cardsLeftToCome == 2) {
				int highCards = CARDS_IN_DECK - outs - 4 - 3;
				int totalPossableCombos = (CARDS_IN_DECK - 4-3) * (CARDS_IN_DECK - 4-4);
				int highCardCombos = highCards * (highCards -1);
				return 1 - ((double)(highCardCombos) / totalPossableCombos);
			}
			// cards left to come should be 5
			
			else {
				// @TODO to be implemented later
				return 0;
			}
	
		}else if( lowBoard.length == 1) {
			// there is one less low card on the board.
			// therefore we need to add that to our out count
			outs += 4;
			// we can not make a low if there is only one card to come and only one card left
			if(cardsLeftToCome == 1) {
				return 0;
			}else if(cardsLeftToCome == 2){
				// find how many combos of low cards make us a low? 
				int totalPossableCombos = (CARDS_IN_DECK - 4-3) * (CARDS_IN_DECK - 4-4);
				// 52 - cards in hand - cards on board
				int outCombos = outs * (outs -4);
				return((double)(outCombos) / totalPossableCombos);
			}
			// cards left to come should be 5
			else {
				
			}
		}
		return 0;
	}
	
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
	 * @TODO might be easier to remove all cards that are in our hand from the board and compute results based on lenghts 
	 */
	private static boolean hasLowDraw(Card[] hand, Card[] board) {
		Card[] lowHand = getLowCards(hand);
		Card[] lowBoard = getLowCards(board);
		// there needs to be at least 2 low cards on the board for a low draw to be possible
		if(lowBoard.length > 1) {
			switch(lowHand.length) {
			case 1:
				// we cannot have any low draw
				return false;
			case 2: 
				// if we have a pair then, we do not have a low draw
				if(lowBoard.length == 2) {
					if(hasPair(lowHand ,lowBoard)) {
						return false;
					}else {
						return true;
					}
				}
			case 3:
				// this should only be true if we do not have 2 pair
				return(!hasTwoPair(lowHand, lowBoard));
			case 4:
				// we will all ways have a low draw if we have 4 low cards and there are 2 on the board
				// our low draw cannot be counterfeited
				return true; 
				
			
			}
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
		return removePairs(give);
		
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
	
	private static Card[] removeCardOfRank(int rank, Card[] set) {
		ArrayList<Card> give = new ArrayList<Card>();
		
		
		for(int i =0; i < set.length; i++) {
			if(set[i].getRank() != rank) {
				give.add(set[i]);
			}
		}
		Card[] pass = new Card[give.size()];
		for(int i = 0 ; i < pass.length; i ++ ) {
			pass[i] = give.get(i);
		}
		return pass;
		
	}
	
	/**
	 * removes any cards of the same rank in hand
	 * @param hand
	 * @return
	 */
	private static Card[] removePairs(Card[] hand) {
		ArrayList<Card> give = new ArrayList<Card>();
		if(hand.length > 0) {
			give.add(hand[0]);
		}
		boolean flag = true;
		for(int x = 1; x < hand.length ; x++) {
			for(int y = 0; y < give.size(); y++) {
				if(give.get(y).getRank() == hand[x].getRank()) {
					flag = false;
				}
			}
			if(flag) {
				give.add(hand[x]);
			}
		}
		
		Card[] pass = new Card[give.size()];
		for(int i = 0; i < pass.length; i++) {
			pass[i] = give.get(i);
		}
		return pass;
	}
	private static boolean hasTwoPair(Card[] hand, Card[] board) {
		int pairCount = 0;
		for(Card i : hand) {
			Card[] test = new Card[1];
			test[0] = i;
			if(hasPair(test, board)) {
				pairCount ++;
				if(pairCount == 2) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	
}
