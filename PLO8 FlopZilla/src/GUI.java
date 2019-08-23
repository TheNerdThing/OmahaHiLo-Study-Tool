

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class GUI extends JFrame{

	PLOhandSelector ploS;
	FlopSelector fs;
	
	JTabbedPane tabbedPane; 

	public GUI() {
		tabbedPane = new JTabbedPane(); 

		this.setBounds(450,10,1000,1000);
		ploS =  new PLOhandSelector(300,300,0,0);
		fs = new FlopSelector(500,250,0,0);
		tabbedPane.addTab("Hand Selector",ploS);
		tabbedPane.addTab("Flop Selector",fs);
		
		this.add(tabbedPane);

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String  printComponets() {
		String give ="";
		for(String i : ploS.getPressed()) {
			give += i;
		}
		return give;
	}

}
