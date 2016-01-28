package corejava.gui.table;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

public class PlanetTableModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return cells.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return cells[row][column];
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return cells[0][columnIndex].getClass();
	}

	private Object[][] cells = {
			{"Mercury",2440.0,0,false,Color.YELLOW},
			{"Venus",6052.0,0,true,Color.YELLOW},
			{"Saturn",2440.0,0,false,Color.BLUE},
			{"Jupitor",2440.0,0,true,Color.ORANGE},
			{"Earth",2440.0,0,false,Color.blue}
			
	};
	private String[] columnNames  = {"Planet","Radius","Moons","Gaseous","Color"};

}
