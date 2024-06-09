package mainFrame.Panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SecondUpperLine extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecondUpperLine() {
		setBounds(102,41,950,10);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(new Color(0x2D2227));
		g2D.setStroke(new BasicStroke(1));
		g2D.drawLine(0, 2, 950, 2);
	}
}
