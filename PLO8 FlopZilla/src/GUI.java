

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class GUI extends JFrame{

	PLOhandSelector ploS;
	FlopSelector fs;
	ResultsPane rp;
	
	JTabbedPane tabbedPane; 

	public GUI() {
		this.setBounds(450,10,1000,1000);
		tabbedPane = new JTabbedPane(); 
		ploS =  new PLOhandSelector(300,300,0,0);
		fs = new FlopSelector(500,250,0,0);
		rp = new ResultsPane();
		tabbedPane.addTab("Hand Selector",ploS);
		tabbedPane.addTab("Flop Selector",fs);
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
		for(String i : ploS.getPressed()) {
			give += i;
		}
		return give;
	}

}
