package mainFrame.Panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mainFrame.Panels.Methdos.DrawLine;
import mainFrame.Panels.Methdos.RoundedLabel;

public class FirstPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font FontSherif;
	Font FontGlacial;
	int FontColor = 0xE8EAEE;
	
	int width = 1215;
	int height = 714;
	JLayeredPane layer = new JLayeredPane();
	public FirstPanel() {
		MainPanel();
	}
private void MainPanel() {
		
		this.setPreferredSize(new Dimension(width,height));
		this.setLayout(null);
		this.setVisible(true);
		
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/1st_page.png").getImage().getScaledInstance(1200, height, Image.SCALE_SMOOTH));
		JLabel label = new JLabel();
		label.setIcon(icon);
		label.setBounds(0,0,width,height);
		
		JLabel middle = new JLabel("GADGETOPIA");
		middle.setBounds(71,230,500,80);
		middle.setForeground(new Color(FontColor));
		middle.setFont(setFontSherif(78));
		
		JLabel belowMiddle = new JLabel("<html>STAY AHEAD WITH TECH <br/>TRENDS!</html>"
				+ "TRENDS!");
		belowMiddle.setBounds(75,300,400,100);
		belowMiddle.setForeground(new Color(FontColor));
		belowMiddle.setFont(setFontSGlacial(29));
	
		JLabel upper = new JLabel("<html>BSCS 121, STI LUCENA</html>");
		upper.setBounds(75,110,400,100);
		upper.setForeground(new Color(FontColor));
		upper.setFont(setFontSGlacial(29));
	
		JLabel below = new JLabel("<html><body><p style=\"padding:4\">"
				+ "A tech company that offers a diverse range of</p>"
				+ "<p style=\"padding:4\">products that cater to tech enthusiasts,</p>"
				+ "<p style=\\\"padding:4\\\">professionals, and casual users alike.</p>"
				+ "</body></html>");
		below.setBounds(75,440,410,100);
		below.setForeground(new Color(FontColor));
		below.setFont(setFontSGlacial(20));
	
		JLabel url = new JLabel("<html>www.gadgetopia.com</html>");
		url.setBounds(0,10,200,20);
		url.setForeground(new Color(FontColor));
		url.setFont(setFontSGlacial(17));
		
		RoundedLabel startBrowsing = new RoundedLabel("", 40);
		JLabel text = new JLabel("START BROWSING");
		text.setForeground(new Color(0x0D131B));
		text.setSize(90,20);
		text.setFont(setFontSGlacial(20));
		startBrowsing.add(text);
		startBrowsing.setBounds(850,0,200,42);
		startBrowsing.setBackground(new Color(0xCCCED2));
		startBrowsing.setFont(setFontSGlacial(20));
		startBrowsing.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startBrowsing.setForeground(new Color(0xCCCED2));
		startBrowsing.setHorizontalAlignment(SwingConstants.CENTER);
		startBrowsing.setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
		startBrowsing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PANEL().removeAll();
            	PANEL().add(new SecondPanel());
            	PANEL().revalidate();
            	PANEL().repaint();
            	
            }});
		
		JPanel buttomSide = new JPanel();
		buttomSide.add(url);
		buttomSide.add(startBrowsing);
		buttomSide.setLayout(null);
		buttomSide.setBounds(75,620,1150,50);
		buttomSide.setOpaque(false);
		
		layer.setBounds(0,0,width,height);
		layer.add(label, Integer.valueOf(0));
		layer.add(middle, Integer.valueOf(1));
		layer.add(belowMiddle, Integer.valueOf(1));
		layer.add(below, Integer.valueOf(1));
		layer.add(upper, Integer.valueOf(1));
		layer.add(buttomSide, Integer.valueOf(2));
		layer.add(new DrawLine(), Integer.valueOf(1));
		
    	
		this.add(layer);
		// Remove after done editing in second panel	

		PANEL().removeAll();
    	PANEL().add(new SecondPanel());
    	PANEL().revalidate();
    	PANEL().repaint();

    	// 
    	
	}
	

	private Font setFontSherif(float fontSize) {
		try {
			FontSherif = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSerifDisplay-Regular.ttf")).deriveFont(fontSize);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSerifDisplay-Regular.ttf")) );
		    
		    return FontSherif;
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return new Font("Arial", Font.PLAIN,(int) fontSize);
		}
	}
	
	private Font setFontSGlacial(float fontSize) {
		try {
			FontGlacial = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/GlacialIndifference-Regular.otf")).deriveFont(fontSize);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/GlacialIndifference-Regular.otf")) );
		    
		    return FontGlacial;
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return new Font("Arial", Font.PLAIN,(int) fontSize);
		}
		
	}
	
	private JPanel PANEL() {
		return this;
	}
	
	public void setWidthAndHeight(int w,int h) {
		width = w;
		height = h;
	}
	
	
}
