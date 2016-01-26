package corejava.gui.event;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				ActionFrame frame = new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});

	}

}
class ActionFrame extends JFrame{
	public ActionFrame(){
		setTitle("Action Test");
		setSize(400,400);
		buttonPanel = new JPanel();
		
		Action yellowAction = new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
		Action blueAction = new ColorAction("Blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
		Action redAction = new ColorAction("Red",new ImageIcon("red-ball.gif"),Color.RED);
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	JPanel buttonPanel;
	
	private class ColorAction extends AbstractAction {
		
		public ColorAction(String name,Icon icon,Color c){
			putValue(Action.NAME,name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION,"Set panel color to "+name);
			putValue("color",c);
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color c = (Color)getValue("color");
			buttonPanel.setBackground(c);
			
		}
		
	}
}