package mainFrame.Panels.navigations;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mainFrame.Panels.Methdos.RoundedLabel;

public class Overview extends JLayeredPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RoundedLabel btn = new RoundedLabel("",40);
	public Overview() {
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setOpaque(false);
		this.setBounds(0,0,1215,550);
		this.add(first(), Integer.valueOf(0));
		this.setLayout(null);
	}
	
	private JPanel first() { 
		JPanel panel = new JPanel();
		RoundedLabel btn = new RoundedLabel("",40);
		JLabel text = new JLabel("NEXT");
		text.setPreferredSize(new Dimension(45,20));
		text.setOpaque(false);
		text.setFont(setFontSGlacial(20));
		btn.add(text);
		btn.setBounds(950,440,180,40);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBackground(new Color(0xCCCED2));
		btn.setForeground(new Color(0xCCCED2));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		panel.setBounds(0,0,1215,550);		
		panel.add(aboutUs());
		panel.add(LogoName());
		panel.add(paragraph());
		panel.add(btn);
		panel.add(url());
		panel.setVisible(true);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED");
            	Pane().removeAll();
            	Pane().add(second());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		
		return panel;
	}
	
	private JPanel second() {
		JLabel products = new JLabel("PRODUCTS:");
		products.setFont(setFontSGlacial(30));
		products.setBounds(560,20,200,31);
		products.setForeground(new Color(0xE8EAEE));
		
		String textList = "<html><ul>"
				+ "<li>Smartphones and Accessories: The newest smartphones, cases, chargers, and other accessories.</li>"
				+ "<li>Wearable Technology: Smartwatches, fitness trackers, and augmented reality glasses.</li>"
				+ "<li>Home Automation: Smart home devices, including speakers, lighting, security systems, and home assistants.</li>"
				+ "<li>Personal Gadgets: Drones, portable projectors, VR headsets, and cutting-edge audio equipment.</li>"
				+ "<li>Computer Peripherals: Innovative keyboards, mice, external storage, and advanced gaming gear.</li>"
				+ "<li>Eco-Friendly Gadgets: Solar chargers, energy-efficient devices, and other sustainable technology.</li>"
				+ "</ul><html>";
		JLabel details = new JLabel(textList);
		details.setBounds(560,50,600,400);
		details.setOpaque(false);
		details.setForeground(new Color(0xE8EAEE)); 
		details.setFont(setFontSGlacial(23));
		
		RoundedLabel btn = new RoundedLabel("",40);
		JLabel text = new JLabel("NEXT");
		text.setPreferredSize(new Dimension(45,20));
		text.setOpaque(false);
		text.setFont(setFontSGlacial(20));
		btn.add(text);
		btn.setBounds(1040,440,90,40);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBackground(new Color(0xCCCED2));
		btn.setForeground(new Color(0xCCCED2));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		RoundedLabel backbtn = new RoundedLabel("",40);
		JLabel back = new JLabel("BACK");
		back.setPreferredSize(new Dimension(48,20));
		back.setOpaque(false);
		back.setFont(setFontSGlacial(20));
		backbtn.add(back);
		backbtn.setBounds(940,440,90,40);
		backbtn.setHorizontalAlignment(SwingConstants.CENTER);
		backbtn.setBackground(new Color(0xCCCED2));
		backbtn.setForeground(new Color(0xCCCED2));
		backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backbtn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,1215,550);
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setVisible(true);
		
		backbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED TWICE");
            	Pane().removeAll();
            	Pane().add(first());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		
		
		btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED TWICE");
            	Pane().removeAll();
            	Pane().add(third());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		
		panel.add(backbtn);
		panel.add(url());
		panel.add(details);
		panel.add(btn);
		panel.add(products);
		return panel;
	}
	
	private JPanel third() {
		RoundedLabel btn = new RoundedLabel("",40);
		JLabel text = new JLabel("NEXT");
		text.setPreferredSize(new Dimension(45,20));
		text.setOpaque(false);
		text.setFont(setFontSGlacial(20));
		btn.add(text);
		btn.setBounds(1040,440,90,40);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBackground(new Color(0xCCCED2));
		btn.setForeground(new Color(0xCCCED2));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		RoundedLabel backbtn = new RoundedLabel("",40);
		JLabel back = new JLabel("BACK");
		back.setPreferredSize(new Dimension(48,20));
		back.setOpaque(false);
		back.setFont(setFontSGlacial(20));
		backbtn.add(back);
		backbtn.setBounds(940,440,90,40);
		backbtn.setHorizontalAlignment(SwingConstants.CENTER);
		backbtn.setBackground(new Color(0xCCCED2));
		backbtn.setForeground(new Color(0xCCCED2));
		backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backbtn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		JLabel top = new JLabel("VISION & MISSION: ADAPT WITH THE FUTURE");
		top.setFont(setFontSGlacial(30));
		top.setBounds(590,20,600,31);
		top.setForeground(new Color(0xE8EAEE));
		
		JLabel mid = new JLabel("<html><p style=\"line-height: 1.8;\" >Our team’s mission is to provide a dynamic platform that fosters collaboration, and technological advancement. We connect tech enthusiasts, startups, and industry leaders, enabling them to C in an ever-evolving digital landscape.</p> </html>");
		mid.setBounds(590,50,450,190);
		mid.setFont(setFontSGlacial(23));
		mid.setForeground(new Color(0xE8EAEE));
		mid.setOpaque(false);
		
		JLabel bot = new JLabel("<html><p style=\"line-height: 1.8;\" >Our team’s vision is to be the go-to hub for all things tech. We aspire to inspire creativity, drive innovation, and shape the future by curating cutting-edge content, hosting events, and building a vibrant community passionate about technology.</p> </html>");
		bot.setBounds(700,250,450,190);
		bot.setFont(setFontSGlacial(23));
		bot.setForeground(new Color(0xE8EAEE));
		bot.setOpaque(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,1215,550);
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setVisible(true);
		
		backbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED TRICE");
            	Pane().removeAll();
            	Pane().add(second());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED TRICE");
            	Pane().removeAll();
            	Pane().add(forth());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		
		panel.add(backbtn);
		panel.add(bot);
		panel.add(mid);
		panel.add(top);
		panel.add(url());
		panel.add(btn);	
		return panel;
	}
	
	private JPanel forth() {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,1215,550);
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel values = new JLabel("VALUES: ");
		values.setFont(setFontSGlacial(30));
		values.setBounds(720,20,600,31);
		values.setForeground(new Color(0xE8EAEE));
		
		String textList = "<html><ul>"
				+ "<li>Values:Innovation: Fostering a culture of creativity and continuous improvement.</li>"
				+ "<li>Quality: Delivering reliable, high-performance technologies that exceed customer expectations.</li>"
				+ "<li>Customer-Centricity: Prioritizing the needs and satisfaction of our customers in all we do.</li>"
				+ "<li>Integrity: Upholding the highest standards of ethics and C.</li>"
				+ "<li>Sustainability: Committing to environmentally responsible practices and products.</li>"
				+ "</ul><html>";
		JLabel details = new JLabel(textList);
		details.setBounds(680,50,500,400);
		details.setOpaque(false);
		details.setForeground(new Color(0xE8EAEE));
		details.setFont(setFontSGlacial(23));
		
		RoundedLabel btn = new RoundedLabel("",40);
		JLabel text = new JLabel("BACK");
		text.setPreferredSize(new Dimension(48,20));
		text.setOpaque(false);
		text.setFont(setFontSGlacial(20));
		btn.add(text);
		btn.setBounds(950,440,180,40);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBackground(new Color(0xCCCED2));
		btn.setForeground(new Color(0xCCCED2));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		
		btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println("IM CLICKED TRICE");
            	Pane().removeAll();
            	Pane().add(third());
            	Pane().revalidate();
            	Pane().repaint();
            }});
		
		panel.add(btn);		
		panel.add(details);
		panel.add(values);
		panel.add(url());
		return panel;
	}
	
	private JLabel aboutUs() {
		JLabel label = new JLabel("ABOUT US:");
		label.setFont(setFontSGlacial(30));
		label.setBounds(560,20,200,31);
		label.setForeground(new Color(0xE8EAEE));
		
		return label;
	}
	
	private JLabel LogoName() {
		JLabel label = new JLabel("GADGETOPIA");
		label.setFont(setFontFoldit(41));
		label.setBounds(560, 60, 400, 60);
		label.setForeground(new Color(0xFFFFFF));
		
		return label;
	}
	
	private JLabel paragraph() {
		String text = "<html>"
				+ "<p align=\"justify\">"
				+ "A leading technology company dedicated"
				+ "<br/>to developing and delivering"
				+ "<br/>groundbreaking technological innovations."
				+ "<br/>Our focus is on creating advanced,"
				+ "<br/>user-friendly solutions that transform"
				+ "<br/>industries and improve everyday life."
				+ "<br/>From cutting-edge gadgets to sophisticated"
				+ "<br/>software and AI-driven solutions,"
				+ "<br/>GADGETOPIA stands at the forefront of"
				+ "<br/>technological advancement."
				+ "</html>";
		
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(setFontSGlacial(24));
		label.setBounds(680,40,500,500);
		label.setForeground(new Color(0xE8EAEE));
		
		return label;
	}
	
	private JLayeredPane Pane() {
		return this;
	}
	
	private JLabel url() {
		JLabel url = new JLabel("www.gadgetopia.com");
		url.setFont(setFontSGlacial(16));
		url.setBounds(80,450, 200,20);
		url.setForeground(new Color(0xE8EAEE));
		return url;
	}
	
	private Font setFontFoldit(float fontSize) {
		Font FontGlacial;
		try {
			FontGlacial = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/static/Foldit-Bold.ttf")).deriveFont(fontSize);
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
}
