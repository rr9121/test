package corejava.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SizedFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				SizedFrame frame = new SizedFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.getContentPane().add(new JButton(""));
				frame.add(new JButton(""));
			}
			
		});

	}

}
class SizedFrame extends JFrame {
	public SizedFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize  = toolkit.getScreenSize();
		int frameWidth = screenSize.width/2;
		int frameHeight = screenSize.height/2;
		
		setSize(frameWidth,frameHeight);
		setLocationByPlatform(true);
		
		setTitle("My First Frame");
		Image img = toolkit.getImage("tree.jpg");
		setIconImage(img);
	}
}