package corejava.gui.layout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GridBagLayoutTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
			
		});

	}

}
class FontFrame extends JFrame {
	public FontFrame(){
		setTitle("GridBagLayout Test");
		setSize(400,400);
		
		GridBagLayout gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		
		JLabel facelabel = new JLabel("Face: ");
		face = new JComboBox(new String[]{"Serif","SansSerif","Monospaced","Dialog","DialogInput"});
		JLabel sizelabel = new JLabel("Size: ");
		size = new JComboBox(new String[]{"8","10","12","15","18","20","24","28","30"});
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		
		area = new JTextArea();
		area.setText("The QUick brown Foxx jumps over the lazy dog");
		area.setEditable(false);
		area.setLineWrap(true);
		area.setBorder(BorderFactory.createEtchedBorder());
		
		add(facelabel,new GBC(0,0).setAnchor(GBC.EAST));
		add(face,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		add(sizelabel,new GBC(0,1).setAnchor(GBC.EAST));
		add(size,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
		
		add(bold,new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(italic, new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		
		add(area,new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
		
	}
	private JComboBox face;
	private JComboBox size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea area;
}

class GBC extends GridBagConstraints {
	public GBC(int gridx,int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}
	
	public GBC(int gridx,int gridy,int gridWidth,int gridHeight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
	}
	
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}
	
	public GBC setWeight(double weightX,double weightY) {
		this.weightx = weightX;
		this.weighty = weightY;
		return this;
	}
	
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance,distance,distance,distance);
		return this;
	}
	public GBC setInsets(int top,int left,int bottom,int right) {
		this.insets = new Insets(top,left,bottom,right);
		return this;
	}
	 public GBC setIpad(int ipadX,int ipadY) {
		 this.ipadx = ipadX;
		 this.ipady = ipadY;
		 return this;
	 }
	
}