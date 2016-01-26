package corejava.gui;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				HelloWorldFrame frame = new HelloWorldFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});
	}

}
class HelloWorldFrame extends JFrame {
	public HelloWorldFrame() {
		setTitle("Hello World");
		setSize(300,400);
		HelloWorldPanel panel = new HelloWorldPanel();
		add(panel);
	}
}
class HelloWorldPanel extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		g.drawString("Hello World", 75, 100);
	}
	
}
