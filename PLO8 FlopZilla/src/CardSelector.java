
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class CardSelector extends SelectorSuper implements ActionListener{
	
	// standard game of flop poker. there are only 5 cards on the board
	private int maxCard ;
	
	public CardSelector(int maxCard, int height, int width, int hStart, int wStart) {
		this.setLayout(new GridLayout(13,4));
		this.maxCard = maxCard;
		for(int x = 14; x > 1; x--) {
			for(int y = 3; y >= 0; y--) {
				JToggleButton add = new JToggleButton();
				add.addActionListener(this);
				add.setText(intRankToString(x) + suiteToString(intToSuite(y)) );
				this.add(add);
			}
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton work;
		if(arg0.getSource() instanceof JToggleButton) {
				work = (JToggleButton) arg0.getSource();
		}else {
			return;
		}
		System.out.println(pressed.size());
		// if we already have the max amount of cards selected then we don't want to add new cards
		if(pressed.size() >= maxCard) {
			work.setSelected(false);
		}
		String text = work.getText();
		if(work.isSelected()) {
			pressed.add(text);
		}else {
			pressed.remove(text);
		}
		
		
	
		
	}


	@Override
	public Card[] getSelected() {
		// TODO Auto-generated method stub
		return null;
	}
}
