
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JToggleButton;


public class HandSelector extends SelectorSuper  implements ActionListener{

	boolean[][] handSelection; 


	
	public HandSelector(int height, int width, int hStart, int wStart) {
		this.setLayout(new GridLayout(13, 13));
		pressed = new ArrayList<String>();
		
		for(int x = 14; x > 1; x--) {
			boolean suited = true;
			for(int y = 14; y > 1; y--) {
				JToggleButton add = new JToggleButton();
				add.addActionListener(this);
				String suitedText;
				if(x == y) {
					suited = false;
				}
				suitedText = suited? "o": "s" ;
				if(x == y) {
					suitedText = "";
				}
				if( x > y) {
					add.setText(intRankToString(x) + intRankToString(y) + suitedText);
				}else {
					add.setText(intRankToString(y) + intRankToString(x) + suitedText);
				}
				this.add(add);
			}
		}
		
	}
	
	
	public void readComponets() {
		for(int i = 0; i < this.getComponentCount(); i++) {
			if(this.getComponent(i) instanceof JToggleButton)
			System.out.println(((JToggleButton) (this.getComponent(i))).getText());
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
		String text = work.getText();
		if(work.isSelected()) {
			pressed.add(text);
		}else {
			pressed.remove(text);
		}
	
		
	}
}