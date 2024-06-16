package mainFrame.Panels.navigations;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.ProductDetails;
import mainFrame.PanelSlider42;
import mainFrame.Panels.Methdos.BackgroundPanel;
import mainFrame.Panels.Methdos.RoundedLabel;
import mainFrame.Panels.SecondPanel;
import mainFrame.Panels.SubPanels.ViewProductDetails;

public class Homes extends JLayeredPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int IMAGE_WIDTH = 354;
	final int IMAGE_HEIGHT = 416;
	JPanel panel;
	JButton rightBtn;
	JButton leftBtn;

	RoundedLabel circle_1;
	RoundedLabel circle_2;
	RoundedLabel circle_3;
	Account account;

	BackgroundPanel backgroundImage;
	JLayeredPane body;
	JPanel userInfo;
	ViewProductDetails viewProduct;
	SecondPanel backHome;

	JPanel current = labels(0);

	int[] sequence = {1, 2, 3};
	int index = 0;
	int direction = 1;  // 1 for forward, -1 for backward
	
	public Homes(BackgroundPanel backgroundImage , JLayeredPane body, JPanel userInfo, SecondPanel backHome, Account account) {
		this.body = body;
		this.backgroundImage = backgroundImage;
		this.userInfo = userInfo;
		this.backHome = backHome;

		this.setVisible(true);
		this.setBounds(0,0,1215,550);
		this.setLayout(null);
		this.setOpaque(false);

		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Options(); // Ensure buttons are initialized
				return null;
			}

			@Override
			protected void done() {
				try {
					get();
					CallLabel(); // Attach listeners to buttons after options are initialized
					add(url(), Integer.valueOf(1));
					add(current, Integer.valueOf(2));
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		};

		worker.execute();
	}

	private void callProduct(JComponent component, ProductDetails productDetails){
		component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		component.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ImageIcon icon = new ImageIcon(new ImageIcon("Images/ProductDetail.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
				backgroundImage.setIcon(icon);
				backgroundImage.setBounds(0,-21,1215,734);
				backgroundImage.revalidate();
				body.removeAll();
				body.setLayout(new BorderLayout());
				viewProduct = new ViewProductDetails(userInfo, productDetails, backHome, account);
				body.add(viewProduct, BorderLayout.CENTER);
				body.revalidate();
				body.repaint();
		}});
	}

	private void CallLabel(){

		if (rightBtn == null || leftBtn == null) {
			throw new IllegalStateException("Buttons are not initialized");
		}

		rightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				direction = 1;
				index = (index + direction + sequence.length) % sequence.length;
				Pane().remove(current);
				current=labels(index);
				current.repaint();
				current.revalidate();
				Pane().add(current);
				try {
					Thread.sleep(100);  // 1000 milliseconds = 1 second
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					System.out.println("Thread was interrupted, Failed to complete operation");
				}

			}
		});
		leftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				direction = -1;
				index = (index + direction + sequence.length) % sequence.length;
				Pane().remove(current);
				current=labels(index);
				current.repaint();
				current.revalidate();
				Pane().add(current);

				try {
					Thread.sleep(100);  // 1000 milliseconds = 1 second
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					System.out.println("Thread was interrupted, Failed to complete operation");
				}

			}
		});

	}

	private void Options() throws Exception {
		// Check if we are on the EDT
		if (SwingUtilities.isEventDispatchThread()) {
			// Directly execute the task since we are on the EDT
			createOptionsPanel();
		} else {
			// Use invokeLater to schedule the task on the EDT
			SwingUtilities.invokeLater(this::createOptionsPanel);
		}
	}

	private void createOptionsPanel() {
		final JPanel Jpanel = new JPanel() {
			{
				final PanelSlider42<JPanel> slider = new PanelSlider42<JPanel>(this);
				final JPanel jPanel = slider.getBasePanel();
				slider.addComponent(firstOption());
				slider.addComponent(secondOption());
				slider.addComponent(thirdOption());

				rightBtn = slider.getRightButton();
				leftBtn = slider.getSlideLeft();

				add(jPanel);
				setBounds(10,20,1180, IMAGE_HEIGHT+10);
				setVisible(true);
				setOpaque(false);
				Pane().add(this, Integer.valueOf(0));
			}
		};
	}

	private JLayeredPane Pane(){
		return this;
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

		callProduct(image_1,new ProductDetails(
				"Lorem Ipsum1",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0xDD1122, 0xAAFFEE, 0x226699,0x123456}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/Pic2_2nd_page.jpg","Images/Pic2_2nd_page.jpg","Images/Pic2_2nd_page.jpg","Images/Pic2_2nd_page.jpg"}
		));
		callProduct(image_2,new ProductDetails(
				"Lorem Ipsum2",
				"Dolor Sit",
				"Headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				150,
				new Integer[]{5, 4, 5, 5, 4},
				new Integer[]{0xFFFFFF, 0x0000FF, 0xFF2255, 0x33FFDD, 0xFDE654,0x654321}, // Colors represented as hex codes (white, blue)
				90,
				new String[]{"Images/Pic1_2nd_page.jpg", "Images/Pic1_2nd_page.jpg","Images/Pic1_2nd_page.jpg","Images/Pic1_2nd_page.jpg"}));
		callProduct(image_3,new ProductDetails(
				"Lorem Ipsum3",
				"Dolor Sit",
				"Phone",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				700,
				new Integer[]{5, 5, 4, 4, 5},
				new Integer[]{0x000000, 0x808080,0x098654, 0x676754, 0x946231, 0x164378 }, // Colors represented as hex codes (black, gray)
				150,
				new String[]{"Images/Pic_3.jpg", "Images/Pic_3.jpg", "Images/Pic_3.jpg","Images/Pic_3.jpg"}
		));

		panel = new JPanel();
		panel.setVisible(true);
		panel.setPreferredSize(new Dimension(1100, IMAGE_HEIGHT + 10));
		//panel
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		panel.setOpaque(false);

		panel.add(image_2);
		panel.add(image_1);
		panel.add(image_3);

		return panel;
	}
	private JPanel secondOption() {
		JLabel image_1 = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/12.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_1.setIcon(icon);
		image_1.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		JLabel image_2 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/11.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_2.setIcon(icon);
		image_2.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		JLabel image_3 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/16.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_3.setIcon(icon);
		image_3.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		callProduct(image_1,new ProductDetails(
				"Lorem Ipsum4",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0xFFFFFF, 0x73781F, 0xF5E35A, 0x5EFAD0}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/12.png","Images/12.png","Images/12.png","Images/12.png"}
		));
		callProduct(image_2,new ProductDetails(
				"Lorem Ipsum5",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0xFFAA44, 0x217DAE, 0X254CEA, 0x231ADE}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/11.png","Images/11.png","Images/11.png","Images/11.png"}
		));
		callProduct(image_3,new ProductDetails(
				"Lorem Ipsum6",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0x235190, 0xFE0924, 0xED2325, 0xDEDEDE}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/16.png","Images/16.png","Images/16.png","Images/16.png"}
		));

		panel = new JPanel();
		panel.setVisible(true);
		panel.setPreferredSize(new Dimension(1100, IMAGE_HEIGHT + 10));
		//panel
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		panel.setOpaque(false);

		panel.add(image_2);
		panel.add(image_1);
		panel.add(image_3);

		return panel;
	}
	private JPanel thirdOption() {
		JLabel image_1 = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/16.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_1.setIcon(icon);
		image_1.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		JLabel image_2 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/26.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_2.setIcon(icon);
		image_2.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		JLabel image_3 = new JLabel();
		icon = new ImageIcon(new ImageIcon("Images/36.png").getImage().getScaledInstance(354, 416, Image.SCALE_SMOOTH));
		image_3.setIcon(icon);
		image_3.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));

		callProduct(image_1,new ProductDetails(
				"Lorem Ipsum7",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0xFEFEDE, 0x778dea, 0x2146de, 0x231fca}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/16.png","Images/16.png","Images/16.png","Images/16.png"}
		));
		callProduct(image_2,new ProductDetails(
				"Lorem Ipsum8",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0x123dea, 0x573def, 0x23189d, 0x231fed}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/26.png","Images/26.png","Images/26.png","Images/26.png"}
		));
		callProduct(image_3,new ProductDetails(
				"Lorem Ipsum9",
				"Dolor Sit",
				"headphones",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				120,
				new Integer[]{4, 5, 4, 5, 4},
				new Integer[]{0x000000, 0xFF0000, 0x9834fa, 0x231dae, 0x2375da, 0x09015d}, // Colors represented as hex codes (black, red)
				80,
				new String[]{"Images/36.png","Images/36.png","Images/36.png","Images/36.png"}
		));

		panel = new JPanel();
		panel.setVisible(true);
		panel.setPreferredSize(new Dimension(1100, IMAGE_HEIGHT + 10));
		//panel
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
	private JPanel labels(int INdex) {
		JPanel current = new JPanel();

		circle_1 = new RoundedLabel("",30);
		circle_1.setPreferredSize(new Dimension(20,20));
		circle_1.setBackground(Color.BLACK);
		circle_1.setForeground(Color.BLACK);
		circle_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		circle_2 = new RoundedLabel("",30);
		circle_2.setPreferredSize(new Dimension(20,20));
		circle_2.setBackground(Color.LIGHT_GRAY);
		circle_2.setForeground(Color.LIGHT_GRAY);
		circle_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		circle_3 = new RoundedLabel("",30);
		circle_3.setPreferredSize(new Dimension(20,20));
		circle_3.setBackground(Color.LIGHT_GRAY);
		circle_3.setForeground(Color.LIGHT_GRAY);
		circle_3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		if(INdex == 0) {
			circle_1.setBackground(Color.BLACK);
			circle_1.setForeground(Color.BLACK);

			circle_2.setBackground(Color.LIGHT_GRAY);
			circle_2.setForeground(Color.LIGHT_GRAY);

			circle_3.setBackground(Color.LIGHT_GRAY);
			circle_3.setForeground(Color.LIGHT_GRAY);
		} else if(INdex == 1) {
			circle_1.setBackground(Color.LIGHT_GRAY);
			circle_1.setForeground(Color.LIGHT_GRAY);

			circle_2.setBackground(Color.BLACK);
			circle_2.setForeground(Color.BLACK);

			circle_3.setBackground(Color.LIGHT_GRAY);
			circle_3.setForeground(Color.LIGHT_GRAY);

		} else {
			circle_1.setBackground(Color.LIGHT_GRAY);
			circle_1.setForeground(Color.LIGHT_GRAY);

			circle_2.setBackground(Color.LIGHT_GRAY);
			circle_2.setForeground(Color.LIGHT_GRAY);

			circle_3.setBackground(Color.BLACK);
			circle_3.setForeground(Color.BLACK);
		}
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
