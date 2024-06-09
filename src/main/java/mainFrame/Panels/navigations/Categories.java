package mainFrame.Panels.navigations;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Categories extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Categories() {
		this.setVisible(true);
		this.setBounds(0,0,1215,550);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(Color.RED);
		this.add(url(), Integer.valueOf(1));
		this.add(trending(), Integer.valueOf(1));
		this.add(NavBar(), Integer.valueOf(1));
		this.add(products(), Integer.valueOf(1));
	}
	
	private JLabel url() {
		JLabel url = new JLabel("www.gadgetopia.com");
		url.setFont(setFontSGlacial(16));
		url.setBounds(60,485, 200,20);
		
		return url;
	}
	
	private JLabel trending() {
		JLabel trending = new JLabel("TRENDING GADGET CATEGORIES");
		trending.setBounds(100,30,600,30);
		trending.setFont(setFontSherif(30));
		
		return trending;
	}
	
	private JPanel products() {
		JPanel panel = new JPanel();
		panel.setBounds(0,170,1215,350);
		panel.setBackground(Color.RED);
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel label = new JLabel("LATEST PRODUCTS");
		label.setFont(setFontSherif(30));
		label.setBounds(500,10,300,50);
		
		
		BufferedImage icon_1;
		BufferedImage rounded_1;
		ImageIcon icon;
		try {
			icon_1 = ImageIO.read(new File("Images/ne.jpg"));
		}
		catch (IOException e){
			icon_1 = null;
		}
		JLabel image_1 = new JLabel();
		rounded_1 = makeRoundedCorner(icon_1, 70, 0);
		icon = new ImageIcon(new ImageIcon(rounded_1).getImage().getScaledInstance(250, 280, Image.SCALE_SMOOTH));
		image_1.setIcon(icon);
		image_1.setBounds(485, 55, 250, 280);
		
		BufferedImage icon_2;
		BufferedImage rounded_2;
		try {
			icon_2 = ImageIO.read(new File("Images/3rd_page_latestkineme.jpg"));
		}
		catch (IOException e){
			icon_2 = null;
		}
		JLabel image_2 = new JLabel();
		rounded_2 = makeRoundedCorner(icon_2, 70, 180);
		icon = new ImageIcon(new ImageIcon(rounded_2).getImage().getScaledInstance(175, 196, Image.SCALE_SMOOTH));
		image_2.setIcon(icon);
		image_2.setBounds(285, 85, 175, 196);
		
		BufferedImage icon_3;
		BufferedImage rounded_3;
		try {
			icon_3 = ImageIO.read(new File("Images/3rdpage_latestkineme2.jpg"));
		}
		catch (IOException e){
			icon_3 = null;
		}
		JLabel image_3 = new JLabel();
		rounded_3 = makeRoundedCorner(icon_3, 70,0);
		icon = new ImageIcon(new ImageIcon(rounded_3).getImage().getScaledInstance(175, 196, Image.SCALE_SMOOTH));
		image_3.setIcon(icon);
		image_3.setBounds(760, 85, 175, 196);
		
		BufferedImage icon_4;
		BufferedImage rounded_4;
		try {
			icon_4 = ImageIO.read(new File("Images/3rd_page_latestkineme3.jpg"));
		}
		catch (IOException e){
			icon_4 = null;
		}
		JLabel image_4 = new JLabel();
		rounded_4 = makeRoundedCorner(icon_4, 70,180);
		icon = new ImageIcon(new ImageIcon(rounded_4).getImage().getScaledInstance(150, 168, Image.SCALE_SMOOTH));
		image_4.setIcon(icon);
		image_4.setBounds(110, 100, 150, 168);
		
		BufferedImage icon_5;
		BufferedImage rounded_5;
		try {
			icon_5 = ImageIO.read(new File("Images/3rdpage_lateskineme4.jpg"));
		}
		catch (IOException e){
			icon_5 = null;
		}
		JLabel image_5 = new JLabel();
		rounded_5 = makeRoundedCorner(icon_5, 70, 180);
		icon = new ImageIcon(new ImageIcon(rounded_5).getImage().getScaledInstance(150, 168, Image.SCALE_SMOOTH));
		image_5.setIcon(icon);
		image_5.setBounds(955,100, 150, 168);
		image_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel.add(image_1);
		panel.add(image_2);
		panel.add(image_3);
		panel.add(image_4);
		panel.add(image_5);
		panel.add(label);
		
		return panel;
	}
	
	private JPanel NavBar() {
		JPanel navBar = new JPanel();
		navBar.setBackground(Color.lightGray);
		navBar.setOpaque(false);
		navBar.setBounds(50,70,1100,100);
		navBar.setVisible(true);
		navBar.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
		
		JLabel laptop = new JLabel("LAPTOP");
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/laptop.png").getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH));
		laptop.setIcon(icon);
		laptop.setPreferredSize(new Dimension(90,100));
		laptop.setOpaque(false);
		laptop.setHorizontalTextPosition(JLabel.CENTER);
		laptop.setVerticalTextPosition(JLabel.BOTTOM);
		laptop.setFont(setFontSGlacial_Bold(18));
		laptop.setBackground(Color.RED);
		laptop.setIconTextGap(10);
		
		JLabel headphone = new JLabel("HEADPHONE");
		icon = new ImageIcon(new ImageIcon("Images/headphone.png").getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH));
		headphone.setIcon(icon);
		headphone.setPreferredSize(new Dimension(120,100));
		headphone.setOpaque(false);
		headphone.setHorizontalTextPosition(JLabel.CENTER);
		headphone.setVerticalTextPosition(JLabel.BOTTOM);
		headphone.setFont(setFontSGlacial_Bold(18));
		headphone.setBackground(Color.RED);
		headphone.setIconTextGap(10);
		
		JLabel smartwatch = new JLabel("SMART WATCH");
		icon = new ImageIcon(new ImageIcon("Images/Smart_Watch.png").getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH));
		smartwatch.setIcon(icon);
		smartwatch.setPreferredSize(new Dimension(150,100));
		smartwatch.setOpaque(false);
		smartwatch.setHorizontalTextPosition(JLabel.CENTER);
		smartwatch.setVerticalTextPosition(JLabel.BOTTOM);
		smartwatch.setFont(setFontSGlacial_Bold(18));
		smartwatch.setBackground(Color.RED);
		smartwatch.setIconTextGap(10);
		
		JLabel phone = new JLabel("PHONE");
		icon = new ImageIcon(new ImageIcon("Images/phone.png").getImage().getScaledInstance(45, 60, Image.SCALE_SMOOTH));
		phone.setIcon(icon);
		phone.setPreferredSize(new Dimension(70,100));
		phone.setOpaque(false);
		phone.setHorizontalTextPosition(JLabel.CENTER);
		phone.setVerticalTextPosition(JLabel.BOTTOM);
		phone.setFont(setFontSGlacial_Bold(18));
		phone.setBackground(Color.RED);
		phone.setIconTextGap(10);
		
		JLabel computer = new JLabel("COMPUTER");
		icon = new ImageIcon(new ImageIcon("Images/computer.png").getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH));
		computer.setIcon(icon);
		computer.setPreferredSize(new Dimension(110,100));
		computer.setOpaque(false);
		computer.setHorizontalTextPosition(JLabel.CENTER);
		computer.setVerticalTextPosition(JLabel.BOTTOM);
		computer.setFont(setFontSGlacial_Bold(18));
		computer.setBackground(Color.RED);
		computer.setIconTextGap(10);
		
		JLabel camera = new JLabel("CAMERA");
		icon = new ImageIcon(new ImageIcon("Images/camera.png").getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH));
		camera.setIcon(icon);
		camera.setPreferredSize(new Dimension(80,100));
		camera.setOpaque(false);
		camera.setHorizontalTextPosition(JLabel.CENTER);
		camera.setVerticalTextPosition(JLabel.BOTTOM);
		camera.setFont(setFontSGlacial_Bold(18));
		camera.setBackground(Color.RED);
		camera.setIconTextGap(10);
		
		JLabel viewAll = new JLabel("VIEW ALL");
		icon = new ImageIcon(new ImageIcon("Images/viewAll.png").getImage().getScaledInstance(90, 40, Image.SCALE_SMOOTH));
		viewAll.setIcon(icon);
		viewAll.setPreferredSize(new Dimension(90,100));
		viewAll.setOpaque(false);
		viewAll.setHorizontalTextPosition(JLabel.CENTER);
		viewAll.setVerticalTextPosition(JLabel.BOTTOM);
		viewAll.setFont(setFontSGlacial_Bold(18));
		viewAll.setBackground(Color.RED);
		viewAll.setIconTextGap(10);
		
		navBar.add(laptop);
		navBar.add(headphone);
		navBar.add(smartwatch);
		navBar.add(phone);
		navBar.add(computer);
		navBar.add(camera);
		navBar.add(viewAll);
		return navBar;
	}

	private Font setFontSherif(float fontSize) {
		Font FontSherif;
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
		Font FontGlacial;
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
	private Font setFontSGlacial_Bold(float fontSize) {
		Font FontGlacial;
		try {
			FontGlacial = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/GlacialIndifference-Bold.otf")).deriveFont(fontSize);
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
	
	private BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius, int cropX) {
	    int w = image.getWidth() - cropX;
	    int h = image.getHeight();
	    BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2 = output.createGraphics();
	    
	    // This is what we want, but it only does hard-clipping, i.e. aliasing
	    // g2.setClip(new RoundRectangle2D ...)

	    // so instead fake soft-clipping by first drawing the desired clip shape
	    // in fully opaque white with antialiasing enabled...
	    g2.setComposite(AlphaComposite.Src);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setColor(Color.WHITE);
	    g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
	    
	    // ... then compositing the image on top,
	    // using the white shape from above as alpha source
	    g2.setComposite(AlphaComposite.SrcAtop);
	    g2.drawImage(image, 0, 0, null);
	    
	    g2.dispose();
	    
	    return output;
	}
	
}
