package mainFrame.Panels.Methdos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class DrawLine extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawLine() {
		this.setBounds(85,610,1050,40);
		this.setOpaque(false);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(new Color(0x3F4044));
		g2D.setStroke(new BasicStroke(1));
		g2D.drawLine(190, 30, 815, 30);
	}

}
