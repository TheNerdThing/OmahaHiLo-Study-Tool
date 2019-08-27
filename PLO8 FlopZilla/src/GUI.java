

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class GUI extends JFrame{

	CardSelector handSelector;
	CardSelector flopSelector;
	ResultsPane rp;
	
	JTabbedPane tabbedPane; 

	public GUI() {
		this.setBounds(450,10,1000,1000);
		tabbedPane = new JTabbedPane(); 
		handSelector =  new CardSelector(4,300,300,0,0);
		flopSelector = new CardSelector(5,500,250,0,0);
		rp = new ResultsPane();
		tabbedPane.addTab("Hand Selector",handSelector);
		tabbedPane.addTab("Flop Selector",flopSelector);
		tabbedPane.addTab("statistics", rp);
		this.add(tabbedPane);

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
//	public void updateResults() {
//		CalcResults.calcResults(ploS.pressed, fs.pressed, rp);
//	}
	public String  printComponets() {
		String give ="";
		for(String i : handSelector.getPressed()) {
			give += i;
		}
		return give;
	}

}
