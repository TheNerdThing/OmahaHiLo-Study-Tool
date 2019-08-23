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
