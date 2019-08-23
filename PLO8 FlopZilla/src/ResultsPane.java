import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * @author Gregory Evevsky
 * TODO
 */
public class ResultsPane extends JPanel{

	private JTable table;
	
	
	public ResultsPane(){
		super();
        table = new JTable();
        // this is a test
        this.add(table);
	}
	
	public void updateTable(Object [][] data , String[] colNames) {
		table = new JTable(data, colNames);
	}

}
