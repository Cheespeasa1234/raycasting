import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

//Honors Computer Science - Mr. Uhl
//Program description: A template class for creating graphical applications

public class GraphicsPanel extends JPanel implements MouseListener {
	
	// Variables for the class
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 1111;
	public static final int PREF_H = 696;
	
	private Point p = new Point(0,0);
	private int l = 10;
	private int a = 0;
	private Line line = new Line(p, l, a);
	
	private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 90);  
	
	private Timer gameTimer = new Timer(1000/60, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			repaint();
			a = slider.getValue();
			line.a=p;
			line.setB(l, a);
		}
	});
	
	// Class constructor BOB tHE BUILDER CAN hE FIX IT?????T?T??/
	public GraphicsPanel() {
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		addMouseListener(this);
		
		gameTimer.start();
	}

	// The method used to add graphical images to the panel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		
		g2.drawString("Angle: " + a, 10, 50);

	}

	/** ******* METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL *********/

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() {

		JFrame frame = new JFrame("My First Panel!");
		JPanel gamePanel = new GraphicsPanel();
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 90);  
		
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(10);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true); 
		slider.setPreferredSize(new Dimension(1000, 80));
		gamePanel.add(slider);

		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}