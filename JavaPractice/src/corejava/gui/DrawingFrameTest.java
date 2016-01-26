package corejava.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawingFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				DrawingFrame frame = new DrawingFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});

	}

}
class DrawingFrame extends JFrame {
	public DrawingFrame(){
		setTitle("Drawing Frame");
		setSize(400,400);
		setLocationByPlatform(true);
		
		DrawComponent drawComp = new DrawComponent();
		add(drawComp);
	}
}
class DrawComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setPaint(Color.RED);
		double leftX = 100;
		double topY  = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.fill(ellipse);
		
		g2.draw(new Line2D.Double(leftX, topY, width+leftX, height+topY));
		
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		
		Ellipse2D cirlcle = new Ellipse2D.Double();
		cirlcle.setFrameFromCenter(centerX, centerY, centerX+150, centerY+150);
		g2.draw(cirlcle);
	}
	
}
