package corejava.gui.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});

	}

}
class ButtonFrame extends JFrame {
	public ButtonFrame() {
		setTitle("Button Test");
		setSize(400,400);
		
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		buttonPanel.add(new JButton("Dummy"));
		buttonPanel.add(new JButton("Dummy"));
		buttonPanel.add(new JButton("Dummy"));
		
		add(buttonPanel,BorderLayout.EAST);
		
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	private class ColorAction implements ActionListener {
		
		public ColorAction(Color c) {
			bgColor = c;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			buttonPanel.setBackground(bgColor);
			
		}
		private Color bgColor;
	}
	
	private JPanel buttonPanel;
}