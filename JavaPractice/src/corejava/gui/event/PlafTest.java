package corejava.gui.event;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class PlafTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				PlafFrame frame = new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});

	}

}
class PlafFrame extends JFrame {
	public PlafFrame() {
		setTitle("Button Test");
		setSize(400,400);
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info:infos) {
			makeButton(info.getName(),info.getClassName());
		}
		add(buttonPanel);
	}
	
	private void makeButton(String name,String plaf) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(plaf);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
			}
			
		});
	}
	
	private JPanel buttonPanel;
}