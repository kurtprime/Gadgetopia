package mainFrame.Panels.navigations;

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
import mainFrame.Panels.Methdos.RoundedLabel;

public class Homes extends JLayeredPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int IMAGE_WIDTH = 354;
	final int IMAGE_HEIGHT = 416;
	JPanel panel;
	
	public Homes() {
		this.setVisible(true);
		this.setBounds(0,0,1215,550);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.add(firstOption(), Integer.valueOf(0));
		this.add(url(),  Integer.valueOf(1));	
		this.add(labels(), Integer.valueOf(2));
	}
	
	private JPanel firstOption() {
		JLabel image_1 = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/Pic2_2nd_page.jpg").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_1.setIcon(icon);
		image_1.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		
		JLabel image_2 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/Pic1_2nd_page.jpg").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_2.setIcon(icon);
		image_2.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		
		JLabel image_3 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/Pic_3.jpg").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_3.setIcon(icon);
		image_3.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(20,10,1150,IMAGE_HEIGHT + 10);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		panel.setOpaque(false);
		
		panel.add(image_2);
		panel.add(image_1);
		panel.add(image_3);

		return panel;
	}
	
	private JLabel url() {
		JLabel url = new JLabel("www.gadgetopia.com");
		url.setFont(setFontSGlacial(16));
		url.setBounds(60,485, 200,20);
		
		return url;
	}
	private JPanel labels() {
		JPanel current = new JPanel();
		RoundedLabel circle_1 = new RoundedLabel("",30);
		circle_1.setPreferredSize(new Dimension(20,20));
		circle_1.setBackground(Color.BLACK);
		circle_1.setForeground(Color.BLACK);
		circle_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		RoundedLabel circle_2 = new RoundedLabel("",30);
		circle_2.setPreferredSize(new Dimension(20,20));
		circle_2.setBackground(Color.LIGHT_GRAY);
		circle_2.setForeground(Color.LIGHT_GRAY);
		circle_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		RoundedLabel circle_3 = new RoundedLabel("",30);
		circle_3.setPreferredSize(new Dimension(20,20));
		circle_3.setBackground(Color.LIGHT_GRAY);
		circle_3.setForeground(Color.LIGHT_GRAY);
		circle_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		circle_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	circle_1.setBackground(Color.BLACK);
        		circle_1.setForeground(Color.BLACK);
        		
        		circle_2.setBackground(Color.LIGHT_GRAY);
        		circle_2.setForeground(Color.LIGHT_GRAY);
        		
        		circle_3.setBackground(Color.LIGHT_GRAY);
        		circle_3.setForeground(Color.LIGHT_GRAY);
            	
            }});
		
		circle_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	circle_1.setBackground(Color.LIGHT_GRAY);
        		circle_1.setForeground(Color.LIGHT_GRAY);
        		
        		circle_2.setBackground(Color.BLACK);
        		circle_2.setForeground(Color.BLACK);
        		
        		circle_3.setBackground(Color.LIGHT_GRAY);
        		circle_3.setForeground(Color.LIGHT_GRAY);
            	
            }});
		
		circle_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	circle_1.setBackground(Color.LIGHT_GRAY);
        		circle_1.setForeground(Color.LIGHT_GRAY);
        		
        		circle_2.setBackground(Color.LIGHT_GRAY);
        		circle_2.setForeground(Color.LIGHT_GRAY);
        		
        		circle_3.setBackground(Color.BLACK);
        		circle_3.setForeground(Color.BLACK);
            	
            }});
		
		current.setBounds(540, 450, 120, 30);
		current.setOpaque(false);
		current.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
		current.setBackground(Color.RED);
		current.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		current.add(circle_1);
		current.add(circle_2);
		current.add(circle_3);
		return current;
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
