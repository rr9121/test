package corejava.jdbc.pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class POSModel extends AbstractTableModel{
	public POSModel(){
		try {
			daoObj = new POSDao();
			products = daoObj.loadProducts();
			items = new ArrayList<LineItem>();
			items.add(new LineItem());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewLineItem(){
		items.add(new LineItem());
		fireTableDataChanged();
	}
	public List<LineItem> getLineItems(){
		return items;
	}
	
	public Product[] getProducts(){
		return products.toArray(new Product[products.size()]);
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		LineItem item = items.get(rowIndex);
		if(columnIndex == PRODUCT_COLUMN) {
			item.setProduct((Product)aValue);
		} else if(columnIndex == QUANTITY_COLUMN){
			item.setQuantity(Double.parseDouble((String)aValue));
		}
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		LineItem item = items.get(rowIndex);
		switch (columnIndex){
			case 0: return item.getProductName();
			case 1: return item.getUom();
			case 2: return item.getPrice();
			case 3: return item.getQuantity();
			case 4: return item.getCost();
		}
		return null;
	}
	
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex == PRODUCT_COLUMN || columnIndex == QUANTITY_COLUMN);
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex <=1 || columnIndex >= 3) {
			return String.class;
		} else {
			return Double.class;
		}
	}
	public void checkoutOrder(){
		SaleOrder order = new SaleOrder();
		order.setLineItems(items);
		double cost = 0;
		for(LineItem item:items) {
			cost += item.getCost();
		}
		order.setCost(cost);
		order.setSaleDate(new Date());
		daoObj.saveOrder(order);
		items = new ArrayList<LineItem>();
		fireTableDataChanged();
	}
	
	List<Product> products;
	List<LineItem> items;
	private POSDao daoObj;
	private String[] columnNames = {"Product","UOM","Price","Quantity","Cost"};
	public static final int PRODUCT_COLUMN =0;
	public static final int QUANTITY_COLUMN =3;
}
