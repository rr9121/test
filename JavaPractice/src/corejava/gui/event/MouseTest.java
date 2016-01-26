package corejava.gui.event;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MouseTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				MouseFrame frame = new MouseFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
			
		});

	}

}
class MouseFrame extends JFrame {
	public MouseFrame(){
		setTitle("Mouse Test");
		setSize(400,400);
		add(new MouseComponent());
	}
}
class MouseComponent extends JComponent {
	public MouseComponent() {
		squares = new ArrayList<Rectangle2D>();
		current = null;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		for(Rectangle2D s:squares){
			g2.draw(s);
		}
	}
	public void add(Point2D point){
		double x = point.getX();
		double y = point.getY();
		current = new Rectangle2D.Double(x-SIDE_LENGTH/2,y-SIDE_LENGTH/2,SIDE_LENGTH,SIDE_LENGTH);
		squares.add(current);
		repaint();
	}
	public Rectangle2D find(Point2D point) {
		for(Rectangle2D s:squares){
			if(s.contains(point))
				return s;
		}
		return null;
	}
	public void remove(Rectangle2D s) {
		if(s == null)
			return;
		if(s == current)
			current = null;
		squares.remove(s);
		repaint();
	}
	private static final int SIDE_LENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			current = find(arg0.getPoint());
			if(current != null && arg0.getClickCount() >= 2)
				remove(current);
				
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			current = find(arg0.getPoint());
			if( current == null)
				add(arg0.getPoint());
		}
		
	}
	private class MouseMotionHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			current = find(arg0.getPoint());
			if(current != null) {
				int x = arg0.getX();
				int y = arg0.getY();
				current.setFrame(x-SIDE_LENGTH/2,y-SIDE_LENGTH/2,SIDE_LENGTH,SIDE_LENGTH);
				repaint();
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			if(find(arg0.getPoint()) != null)
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			else
				setCursor(Cursor.getDefaultCursor());
			
		}
		
	}
}