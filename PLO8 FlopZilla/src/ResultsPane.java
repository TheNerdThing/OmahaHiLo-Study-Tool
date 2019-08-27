
import java.awt.GridLayout;

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
		this.setLayout(new GridLayout(1,1));
        table = new JTable();
        
	}
	
	public void updateTable(Object [][] data , String[] colNames) {
		this.remove(table);
		table = new JTable(data, colNames);
		this.add(table);
	}

}
