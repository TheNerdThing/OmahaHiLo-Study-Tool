

import javax.swing.JFrame;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class GUI extends JFrame{

	PLOhandSelector ploS;
	FlopSelector fs;

	public GUI() {
		this.setBounds(450,10,1000,1000);
		ploS =  new PLOhandSelector(300,300,0,0);
		fs = new FlopSelector(500,250,0,0);
		this.add(fs);
		this.add(ploS);
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
