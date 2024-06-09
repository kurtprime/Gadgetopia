package mainFrame.Panels.Methdos;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundPanel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int WIDTH = 1215;
	final int HEIGHT =734;
	private int yAxis = -15;
	ImageIcon iconImage;
	public BackgroundPanel() {
		this.setIconImage(new ImageIcon(new ImageIcon("Images/Background-second.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		this.setIcon(getIconImage());
		this.setBounds(0,getYAxis(),WIDTH,HEIGHT);

	}
	
	public void setYAxis(int y) {
		yAxis = y;
	}
	public int getYAxis() {
		return yAxis;
	}
	public void setIconImage(ImageIcon icon) {
		iconImage = icon;
	}
	
	public ImageIcon getIconImage() {
		return iconImage;
	}
}
