

import javax.swing.JFrame;


/**
 * @author Gregory Evevsky
 * TODO
 */
public class Tester extends JFrame{

	PLOhandSelector test;

	public Tester() {
		this.setBounds(450,10,1000,1000);
		test =  new PLOhandSelector(500,500,0,0);
		this.add(test);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String  printComponets() {
		String give ="";
		for(String i : test.getPressed()) {
			give += i;
		}
		return give;
	}
	

}
