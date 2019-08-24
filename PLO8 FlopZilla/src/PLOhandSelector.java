import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

/**
 * @author Gregory Evevsky
 * only change to this class is to limit the user to selecting 2 hands. 
 */
public class PLOhandSelector extends HandSelector{

	private static final int MAX_HANDS_SELECTED = 2;
	
	public PLOhandSelector(int height, int width, int hStart, int wStart) {
		super(height, width, hStart, wStart);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Card[] getSelected() {
		int size; 
		if(pressed.size() == 2) {
			size = 4;
		}else if(pressed.size() == 1) {
			size = 2;
		}else {
			// means no hand is selected
			return null;
		}
		Card[] give = new Card[size];
		// case 1 both combos are pairs
		if(pressed.get(0).charAt(0) == pressed.get(0).charAt(1) && pressed.get(1).charAt(0) == pressed.get(1).charAt(1)) {
			
		}
		// case 2 there is a pair
		if(pressed.get(0).charAt(0) == pressed.get(0).charAt(1)) {
			// first combo is a pair
			
		}
		if(pressed.get(1).charAt(0) == pressed.get(1).charAt(1)) {
			//second combo is a pair
		}
		// case 3 neither combo is suited
		if(pressed.get(0).charAt(2) == 'o' && pressed.get(1).charAt(2) == 'o') {
			
		}
		// case 4 one combo is suited
		// case 5 both combos are suited
		if(pressed.get(0).charAt(2) == 's' && pressed.get(1).charAt(2) == '0') {
			
		}
		return give;
	}
	
	private Card[] stringToCard(String hand) {
		Card[] give = new Card[2];
		
		return give; 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton work;
		if(arg0.getSource() instanceof JToggleButton) {
				work = (JToggleButton) arg0.getSource();
		}else {
			return;
		}
		String text = work.getText();
		
		if(pressed.size() >= MAX_HANDS_SELECTED) {
			work.setSelected(false);
		}
		if(work.isSelected()) {
			pressed.add(text);
		}else {
			pressed.remove(text);
		}
	
		
	}

}
