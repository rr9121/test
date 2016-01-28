package corejava.gui.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class PlanetTable {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				PlanetTableFrame frame = new PlanetTableFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});

	}

}
class PlanetTableFrame extends JFrame {
	public PlanetTableFrame(){
		setTitle("Planet Table");
		setSize(400,400);
		setLocationByPlatform(true);
		
		//JTable table = new JTable(cells,columnNames);
		JTable table = new JTable(new PlanetTableModel());
		
		table.setDefaultRenderer(Color.class, new ColorColumnRenderer());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
		
	}
	private Object[][] cells = {
			{"Mercury",2440.0,0,false,Color.YELLOW},
			{"Venus",6052.0,0,false,Color.YELLOW},
			{"Saturn",2440.0,0,false,Color.BLUE},
			{"Jupitor",2440.0,0,false,Color.ORANGE},
			{"Earth",2440.0,0,false,Color.blue}
			
	};
	private String[] columnNames  = {"Planet","Radius","Moons","Gaseous","Color"};
}
class ColorColumnRenderer extends JPanel implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		setBackground((Color)value);
		if(hasFocus)
			setBorder(UIManager.getBorder("Table.focusCellHigjlightBorder"));
		else 
			setBorder(null);
		return this;
	}
	
}