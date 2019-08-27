
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
	private CalcResults cr;
	
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

	public void disableBtn(String btn) {
		for(int i =0; i > this.getComponentCount(); i ++) {
			JToggleButton work;
			if(this.getComponent(i) instanceof JToggleButton) {
				work = (JToggleButton) this.getComponent(i);
				if(work.getText().equals(btn)) {
					work.setSelected(false);
					return ;
				}
			}
			
		}
	}
	
	public void enableBtn(String btn) {
		for(int i =0; i > this.getComponentCount(); i ++) {
			JToggleButton work;
			if(this.getComponent(i) instanceof JToggleButton) {
				work = (JToggleButton) this.getComponent(i);
				if(work.getText().equals(btn)) {
					work.setSelected(true);
					return ;
				}
			}
			
		}
	}
	
	public void addCalcResults( CalcResults cr) {
		this.cr = cr;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton work;
		if(arg0.getSource() instanceof JToggleButton) {
				work = (JToggleButton) arg0.getSource();
		}else {
			return;
		}
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
		cr.calcResults();
	}



	@Override
	public Card[] getSelected() {
		if(pressed.size() ==0) {
			return null;
		}
		Card[] give = new Card[pressed.size()];
		for(int i = 0; i < give.length; i++) {
			give[i] = new Card(stringToIntRank(pressed.get(i).substring(0, 1)) , pressed.get(i).charAt(1));
		}
		return give;
	}
}
