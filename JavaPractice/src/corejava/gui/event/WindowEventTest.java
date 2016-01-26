package corejava.gui.event;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowEventTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				WindowTestFrame frame = new WindowTestFrame();
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				
			}
			
		});

	}

}
class WindowTestFrame extends JFrame {
	public WindowTestFrame() {
		setTitle("Window Event Test");
		setSize(400,400);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("windowClosing");
				if(JOptionPane.showConfirmDialog(null, "Do you want to exit?") == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
	
		});
	}
}