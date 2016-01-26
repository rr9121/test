package corejava.gui.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextDemo {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				TextFrame frame = new TextFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});

	}

}
class TextFrame extends JFrame {
	public TextFrame() {
		setTitle("Text Demo");
		setSize(400,400);
		
		JTextField textField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User Name :",SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password :",SwingConstants.RIGHT));
		northPanel.add(pwdField);
		
		add(northPanel,BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea(8,40);
		JScrollPane scrolPane = new JScrollPane(textArea);
		
		add(scrolPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		add(southPanel,BorderLayout.SOUTH);
	}
}