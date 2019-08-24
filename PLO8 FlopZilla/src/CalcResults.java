
/**
 * @author Gregory Evevsky
 * TODO Impliment class
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
	private static boolean hasNonNutLowDraw(Card[] hand, Card[] board) {return false;}
	private static boolean hasStr8Draw     (Card[] hand, Card[] board) {return false;}
	private static boolean hasPair         (Card[] hand, Card[] board) {return false;}
	
	
}
