package corejava.jdbc.pos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class POSTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				POSFrame frame = new POSFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});

	}

}

class POSFrame extends JFrame {
	public POSFrame(){
		setTitle("Point Of Sale");
		setSize(500,500);
		setLocationByPlatform(true);
		
		posModel = new POSModel();
		posTable = new JTable(posModel);
		
		JScrollPane scrollPane = new JScrollPane(posTable);
		add(scrollPane,BorderLayout.CENTER);
		setCellEditors();
		addButtonPanel();
	}
	private void addButtonPanel(){
		JPanel buttonPanel = new JPanel();
		totalField = new JTextField(10);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				posModel.addNewLineItem();
			}
		});
		JButton checkOutBtn = new JButton("Checkout");
		checkOutBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				posModel.checkoutOrder();
				
			}
			
		});
		buttonPanel.add(new JLabel("Order Cost :"));
		buttonPanel.add(totalField);
		buttonPanel.add(addButton);
		buttonPanel.add(checkOutBtn);
		add(buttonPanel,BorderLayout.AFTER_LAST_LINE);
	}
	private void setCellEditors(){
		JComboBox<Product> productBox = new JComboBox<Product>(posModel.getProducts());
		posTable.getColumnModel().getColumn(POSModel.PRODUCT_COLUMN).setCellEditor(new DefaultCellEditor(productBox));
		productBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				posTable.repaint();
				
			}
			
		});
		JTextField qtyField = new JTextField(6);
		qtyField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent arg0) {
				double orderCost = 0;
				List<LineItem> items = posModel.getLineItems();
				for(LineItem item:items) {
					orderCost += item.getCost();
				}
				totalField.setText(String.format("%.2f",orderCost ));
			}
			
		});
		posTable.getColumnModel().getColumn(POSModel.QUANTITY_COLUMN).setCellEditor(new DefaultCellEditor(qtyField));
	}
	private POSModel posModel;
	private JTable posTable;
	private JTextField totalField;
}
