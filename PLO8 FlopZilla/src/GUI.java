
import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class GUI extends JFrame {

	CardSelector handSelector;
	CardSelector flopSelector;
	ResultsPane  rp;
	CalcResults cr;
	JTabbedPane tabbedPane; 

	public GUI() {
		handSelector =  new CardSelector(4, 300,300,0,0);
		flopSelector = new CardSelector(5, 500,250,0,0);
		rp = new ResultsPane();
		cr = new CalcResults(flopSelector, handSelector, rp);
		handSelector.addCalcResults(cr);
		flopSelector.addCalcResults(cr);
		this.setBounds(450,10,1000,1000);
		tabbedPane = new JTabbedPane(); 
		
	
		
		tabbedPane.addTab("Hand Selector",handSelector);
		tabbedPane.addTab("Flop Selector",flopSelector);
		tabbedPane.addTab("Statistics", rp);
		this.add(tabbedPane);

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		updateResults();
	}
	
	public void updateResults() {
		CalcResults.calcResults(handSelector.getSelected(), flopSelector.getSelected(), rp);
	}

	public String  printComponets() {
		String give ="";
		for(String i : handSelector.getPressed()) {
			give += i;
		}
		return give;
	}

}
