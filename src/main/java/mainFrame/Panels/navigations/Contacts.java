package mainFrame.Panels.navigations;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
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
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mainFrame.Panels.Methdos.LightScrollPane;
import mainFrame.Panels.Methdos.RoundedLabel;

public class Contacts extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Contacts() {
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setOpaque(false);
		this.setBounds(0,0,1215,550);
		this.setLayout(null);
		this.add(sendMessage());
		body();
	}

	private void body() {
		JLabel contactUs = new JLabel("CONTACT US");
		contactUs.setFont(setFontSherif(35));
		contactUs.setBounds(100,25,300,36);
		contactUs.setForeground(new Color(0xE8EAEE));
		
		JLabel phone = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/telephone.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		phone.setIcon(icon);
		phone.setBackground(new Color(0xFFFFFF));
		phone.setOpaque(false);
		phone.setBounds(55,80,300,81);
		phone.setForeground(new Color(0xBEC0D3));
		JLabel phoneNumber = new JLabel("PHONE NUMBER");
		phoneNumber.setFont(setFontSGlacial_BOLD(18));
		phoneNumber.setBounds(120,20,200,20);
		phoneNumber.setForeground(new Color(0xBEC0D3));
		JLabel number = new JLabel("+639-912-1567-858");
		number.setFont(setFontSGlacial_BOLD(20));
		number.setBounds(100,40,200,20);
		number.setForeground(new Color(0xBEC0D3));
		phone.add(number);
		phone.add(phoneNumber);
		
		JLabel Email = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/email.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Email.setIcon(icon);
		Email.setBackground(new Color(0xFFFFFF));
		Email.setOpaque(false);
		Email.setBounds(55,170,400,81);
		Email.setForeground(new Color(0xBEC0D3));
		JLabel EmailAddress = new JLabel("EMAIL ADDRESS");
		EmailAddress.setFont(setFontSGlacial_BOLD(18));
		EmailAddress.setBounds(130,20,300,20);
		EmailAddress.setForeground(new Color(0xBEC0D3));
		JLabel GMAIL = new JLabel("GADGETOPIA@GMAIL.COM");
		GMAIL.setFont(setFontSGlacial_BOLD(17));
		GMAIL.setBounds(90,40,300,20);
		GMAIL.setForeground(new Color(0xBEC0D3));
		Email.add(EmailAddress);
		Email.add(GMAIL);
		
		JLabel Location = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/location.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Location.setIcon(icon);
		Location.setBackground(new Color(0xFFFFFF));
		Location.setOpaque(false);
		Location.setBounds(55,250,320,81);
		Location.setForeground(new Color(0xBEC0D3));
		JLabel Loc = new JLabel("LOCATION");
		Loc.setFont(setFontSGlacial_BOLD(18));
		Loc.setBounds(135,20,200,20);
		Loc.setForeground(new Color(0xBEC0D3));
		JLabel Local = new JLabel("SAN JUAN, METRO MANILA");
		Local.setFont(setFontSGlacial_BOLD(16));
		Local.setBounds(90,40,300,20);
		Local.setForeground(new Color(0xBEC0D3));
		Location.add(Loc);
		Location.add(Local);
		
		
		JLabel follow = new JLabel ("FOLLOW US ON:");
		follow.setFont(setFontSherif(22));
		follow.setBounds(70,350,300,22);
		follow.setForeground(new Color(0xE8EAEE));
		
		
		JPanel socials = new JPanel();
		socials.setBounds(70,380,300,70);
		socials.setVisible(true);
		socials.setOpaque(false);
		socials.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		JLabel fb = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/fb.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		fb.setIcon(icon);
		fb.setPreferredSize(new Dimension(45,45));
		fb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel insta = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/insta.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		insta.setIcon(icon);
		insta.setPreferredSize(new Dimension(45,45));
		insta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel twt = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/x.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		twt.setIcon(icon);
		twt.setPreferredSize(new Dimension(45,45));
		twt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel tiktok = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/tiktok.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		tiktok.setIcon(icon);
		tiktok.setPreferredSize(new Dimension(45,45));
		tiktok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		fb.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	URI uri = null;
				try {
					uri = new URL("https://www.facebook.com/princessjoy.lumbre").toURI();
				} catch (MalformedURLException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	openWebpage(uri);
	         }
	     });
		
		insta.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	URI uri = null;
				try {
					uri = new URL("https://www.instagram.com/hesennyyy").toURI();
				} catch (MalformedURLException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	openWebpage(uri);
	         }
	     });
		
		twt.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	URI uri = null;
				try {
					uri = new URL("https://x.com/taizi_dianxiahc").toURI();
				} catch (MalformedURLException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	openWebpage(uri);
	         }
	     });
		
		tiktok.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	URI uri = null;
				try {
					uri = new URL("https://www.tiktok.com/@spbunny07/video/7371774536141884678?is_from_webapp=1&sender_device=pc").toURI();
				} catch (MalformedURLException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	openWebpage(uri);
	         }
	     });
		
		socials.add(fb);
		socials.add(insta);
		socials.add(twt);
		socials.add(tiktok);
		
		this.add(socials);
		this.add(follow);
		this.add(phone);
		this.add(Email);
		this.add(Location);
		this.add(url());
		this.add(contactUs);;
	}
	
	private JPanel sendMessage() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBounds(500,20,500,500);
		panel.setOpaque(false);
		
		JLabel message = new JLabel("SEND A MESSAGE");
		message.setBounds(80,45,300,35);
		message.setFont(setFontSherif(33));
		message.setForeground(new Color(0x323B44));
		
		JLabel name = new JLabel("NAME:");
		name.setBounds(75,115,100,35);
		name.setFont(setFontSGlacial_BOLD(20));
		name.setForeground(new Color(0x323B44));
		
		JLabel email = new JLabel("EMAIL:");
		email.setBounds(75,160,300,35);
		email.setFont(setFontSGlacial_BOLD(20));
		email.setForeground(new Color(0x323B44));
		
		JLabel mess = new JLabel("MESSAGE:");
		mess.setBounds(75,205,300,35);
		mess.setFont(setFontSGlacial_BOLD(20));
		mess.setForeground(new Color(0x323B44));
		
		RoundedLabel submit = new RoundedLabel("",45);
		submit.setBounds(250,370,165,50);
		submit.setOpaque(false);
		submit.setForeground(Color.white);
		submit.setBackground(Color.white);
		submit.setLayout(new FlowLayout(FlowLayout.CENTER,0,7));
		
		JLabel sub = new JLabel("SUBMIT");
		sub.setFont(setFontSherif(25));
		sub.setBackground(Color.RED);
		sub.setSize(100,27);
		sub.setOpaque(false);
		submit.add(sub);
		
		JTextField nameField = new JTextField();
		nameField.setOpaque(false);
		nameField.setFont(setFontSGlacial_BOLD(20));
		nameField.setForeground(new Color(0x323B44));
		nameField.setBounds(145,115,200,35);
		nameField.setBorder(null);
		nameField.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JTextField emailField = new JTextField();
		emailField.setOpaque(false);
		emailField.setFont(setFontSGlacial_BOLD(20));
		emailField.setForeground(new Color(0x323B44));
		emailField.setBounds(145,160,200,35);
		emailField.setBorder(null);
		emailField.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JTextArea messageArea = new JTextArea();
		messageArea.setBounds(75,235,340,130);
		messageArea.setFont(setFontSGlacial(20));
		messageArea.setOpaque(false);
		messageArea.setLineWrap(true);
		LightScrollPane  sp = new LightScrollPane(messageArea);
		sp.setBounds(75,235,340,130);
		sp.setOpaque(false);
		sp.setBorder(null);
		
		panel.add(sp);
		panel.add(emailField);
		panel.add(nameField);
		panel.add(submit);
		panel.add(email);
		panel.add(mess);
		panel.add(name);
		panel.add(message);
		return panel;
	}
	
	private JLabel url() {
		JLabel url = new JLabel("www.gadgetopia.com");
		url.setFont(setFontSGlacial(16));
		url.setBounds(80,450, 200,20);
		url.setForeground(new Color(0xE8EAEE));
		return url;
	}
	
	public boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	public boolean openWebpage(URL url) {
	    try {
	        return openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	    return false;
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
	private Font setFontSGlacial_BOLD(float fontSize) {
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
	
}
