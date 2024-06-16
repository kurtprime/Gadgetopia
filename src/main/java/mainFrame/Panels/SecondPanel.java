package mainFrame.Panels;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.Cart;
import mainFrame.Panels.Methdos.*;
import mainFrame.Panels.SubPanels.Login;
import mainFrame.Panels.SubPanels.MyCart;
import mainFrame.Panels.SubPanels.SignUp;
import mainFrame.Panels.SubPanels.UserInfo;
import mainFrame.Panels.navigations.Categories;
import mainFrame.Panels.navigations.Contacts;
import mainFrame.Panels.navigations.Homes;
import mainFrame.Panels.navigations.OutputBody;
import mainFrame.Panels.navigations.Overview;

import static java.lang.System.err;


public class SecondPanel extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	final int WIDTH = 1215;
	final int HEIGHT = 714;
	

	BackgroundPanel backgroundImage = new BackgroundPanel();

	OutputBody outputBody = new OutputBody();
	JLayeredPane body = body(true);
	Homes homeBody;
	Categories categoriesBody = new Categories();
	Overview overviewBody = new Overview();
	Contacts contactBody = new Contacts();

	
	JButton LogIn;
	JButton SignIn;

	private JComponent username;
	private Account account;

	public SecondPanel() {
		username = SignInLogIn();
		account = null;
		Size();
	}
	
	private void Size(){
		this.setLayout(null);
		this.setBounds(0,0,WIDTH,HEIGHT);
		this.removeAll();
		this.add(backgroundImage, Integer.valueOf(0));
		this.add(Header(), Integer.valueOf(1));
		this.add(username, Integer.valueOf(2));
		outputBody.add(homeBody);
		this.add(body,Integer.valueOf(1));
		this.setVisible(true);
	}
	private JLayeredPane body(boolean addNow) {
		JLayeredPane body = new JLayeredPane();

		body.setBounds(0, 80, WIDTH, 614);
		body.setOpaque(false);
		body.setBackground(Color.red);
		body.setLayout(null);

		outputBody.removeAll();

		body.add(outputBody, Integer.valueOf(1));
		body.add(NavBar(), Integer.valueOf(1));
		body.add(NavBarBTN(), Integer.valueOf(2));
		body.add(UserInfo(), Integer.valueOf(1));

		homeBody = new Homes(backgroundImage, body, UserInfo(), (SecondPanel) PANE(), account);
		outputBody.add(homeBody);

		return body;
	}
	
	private JLabel LogoName() {
		JLabel label = new JLabel("GADGETOPIA");
		label.setFont(setFontFoldit(41));
		label.setBounds(30, 10, 400, 60);
		label.setForeground(new Color(0xFFFFFF));
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				backHome();
            }});
		
		return label;
	}

	private JLabel userName(String s){

		JLabel label = new JLabel("@"+s);
		final int FONT_SIZE = 22;

		label.setOpaque(false);
		label.setFont(setFontSGlacial(FONT_SIZE));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0xFFFFFF));
		label.setBounds(980,15,200,45);

		return label;
	}

	private JLabel SignInLogIn() {
		JLabel label = new JLabel("|");
		Login LoginPane = new Login();

		final int FONT_SIZE = 22;
		
		SignIn = new JButton("SIGN UP");
		SignIn.setBounds(110, 8, 90, 30);
		SignIn.setMargin(new Insets(0,0,0,0));
		SignIn.setOpaque(false);
		SignIn.setBorderPainted(false); 
		SignIn.setContentAreaFilled(true); 
		SignIn.setBackground(new Color(0xDEDFD8));
		SignIn.setFocusPainted(false); 	
		SignIn.setForeground(new Color(0xFFFFFF));
		SignIn.setFont(setFontSGlacial(FONT_SIZE));
		SignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		SignIn.setPreferredSize(new Dimension(90,30));
		
		LogIn = new JButton("LOGIN");
		LogIn.setBounds(10, 8, 80, 30);
		LogIn.setMargin(new Insets(0,0,0,0));
		LogIn.setOpaque(false);
		LogIn.setBorderPainted(false); 
		LogIn.setContentAreaFilled(true); 
		LogIn.setBackground(new Color(0xDEDFD8));
		LogIn.setFocusPainted(false); 	
		LogIn.setForeground(new Color(0xFFFFFF));
		LogIn.setFont(setFontSGlacial(FONT_SIZE));
		LogIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		LogIn.setPreferredSize(new Dimension(80,30));
		
		SignIn.addActionListener(e->{
			SignUp signup = SignUpPane();
			ImageIcon icon = new ImageIcon(new ImageIcon("Images/bglogin&signup.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
    		backgroundImage.setIcon(icon);
    		backgroundImage.setBounds(0,-21,1215,734);
    		backgroundImage.revalidate();
    		SignIn.setOpaque(true);
    		SignIn.repaint();
    		
    		LogIn.setOpaque(false);
    		LogIn.repaint();
    		
    		body.removeAll(); 		
    		body.setLayout(null);
    		
    		JLabel backBtn = btn("BACK",50,25, setFontSGlacial(20));
    		backBtn.setBounds(50,530,180,40);
    		body.add(backBtn);
    		body.add(url());
    		body.add(signup, Integer.valueOf(1));
			body.revalidate();
    		backBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
					backHome();
                }});
			JLabel signupBtn = signup.signUpBtn();
			signupBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(signup.validSignup())
						LoginPanel(LoginPane);
				}});
		});

		LogIn.addActionListener(e->{
			LoginPanel(LoginPane);
		});
		
		label.setOpaque(false);
		label.add(SignIn);
		label.add(LogIn);
		label.setFont(setFontSGlacial(FONT_SIZE));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0xFFFFFF));
		label.setBounds(980,15,200,45);

		return label;
	}

	private JLabel btn(String t, int x, int y, Font fnt) {
		RoundedLabel btn = new RoundedLabel("",40);
		JLabel text = new JLabel(t);
		text.setPreferredSize(new Dimension(x,y));
		text.setOpaque(false);
		text.setFont(fnt);
		btn.add(text);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBackground(new Color(0xCCCED2));
		btn.setForeground(new Color(0xCCCED2));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));

		return btn;
	}

	private void LoginPanel(Login LoginPane){
		ImageIcon icon = new ImageIcon(new ImageIcon("Images/bglogin&signup.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
		backgroundImage.setIcon(icon);
		backgroundImage.setBounds(0,-21,1215,734);
		backgroundImage.revalidate();

		SignIn.setOpaque(false);
		SignIn.repaint();
		LogIn.setOpaque(true);
		LogIn.repaint();

		body.removeAll();
		body.setLayout(null);
		JLabel backBtn = btn("BACK",50,25, setFontSGlacial(20));
		backBtn.setBounds(50,530,180,40);
		body.add(backBtn);
		body.add(url());

		body.add(LoginPane, Integer.valueOf(1));
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backHome();
			}});
		JLabel loginBtn = LoginPane.getLoginbtn();
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					account = LoginPane.getData();
					System.out.println(account.getUsername());
					PANE().remove(username);
					username = userName(account.getUsername());
					PANE().add(username, Integer.valueOf(2));
					backHome();
					PANE().revalidate();
					PANE().repaint();

				}catch (NullPointerException ex){
					System.err.println(ex);
				}
			}});
	}

	private SignUp SignUpPane() {
        return new SignUp();
	}


	public void backHome(){
		PANE().remove(body);
		body = body(false);
		PANE().add(body,Integer.valueOf(1));

		ImageIcon icon = new ImageIcon(new ImageIcon("Images/Background-second.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
		backgroundImage.setIcon(icon);
		backgroundImage.setBounds(0,-15,1215,734);
		backgroundImage.revalidate();
		LogIn.setOpaque(false);
		SignIn.setOpaque(false);

		PANE().revalidate();
	}

	private JPanel UserInfo() {
		JPanel panel = new JPanel();
		panel.setBounds(1060,35,120,40);
		panel.setVisible(true);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		
		ImageIcon cartIcon = new ImageIcon(new ImageIcon("Images/cart_icon.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		JButton cart = new JButton();
		cart.setIcon(cartIcon);
		cart.setBounds(0,0,40,40);
		cart.setMargin(new Insets(0,0,0,0));
		cart.setOpaque(false);
		cart.setBorderPainted(false); 
		cart.setContentAreaFilled(false); 
		cart.setFocusPainted(false); 	
		cart.setForeground(new Color(0xFFFFFF));
		cart.setFont(setFontSGlacial(20));
		cart.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon userIcon = new ImageIcon(new ImageIcon("Images/user-icon.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		JButton profile = new JButton();
		profile.setIcon(userIcon);
		profile.setBounds(50,0,40,40);
		profile.setMargin(new Insets(0,0,0,0));
		profile.setOpaque(true);
		profile.setBorderPainted(false); 
		profile.setContentAreaFilled(false); 
		profile.setFocusPainted(false); 	
		profile.setForeground(new Color(0xFFFFFF));
		profile.setFont(setFontSGlacial(20));
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));

		cart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Cart[] cart = account.getCart();
					MyCart myCartClass = new MyCart(cart, account.getUsername(), (SecondPanel) PANE());
					//Cart[] cart = null;
					ImageIcon icon = new ImageIcon(new ImageIcon("Images/user_profile.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
					backgroundImage.setIcon(icon);
					backgroundImage.setBounds(0,-21,1215,734);
					backgroundImage.revalidate();

					body.removeAll();
					body.setLayout(new BorderLayout());
					body.add(myCartClass, BorderLayout.CENTER);
					body.revalidate();
					myCartClass.getRemoveBTN().addActionListener(ep->{
						myCartClass.revalidate();
						myCartClass.repaint();
					});

				}catch (Exception ex){
					System.err.println(ex);
					JOptionPane.showMessageDialog(null, "Please LOGIN first",
							"Luh", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		profile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(account == null){
					JOptionPane.showMessageDialog(null, "Please login first",
							"Login First",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				UserInfo userInfo = new UserInfo(getAccount());
				ImageIcon icon = new ImageIcon(new ImageIcon("Images/user_profile.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
				backgroundImage.setIcon(icon);
				backgroundImage.setBounds(0,-21,1215,734);
				backgroundImage.revalidate();
				body.removeAll();
				body.setLayout(new BorderLayout());
				body.add(userInfo, BorderLayout.CENTER);
				body.revalidate();
				userInfo.getSettingIcon().addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						ImageIcon icon = new ImageIcon(new ImageIcon("Images/settings.png").getImage().getScaledInstance(1200,700, Image.SCALE_SMOOTH));
						backgroundImage.setIcon(icon);
						backgroundImage.revalidate();
					}});
				userInfo.getBackHome().addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						backHome();
					}});
			}
		});
		
		panel.add(cart);
		panel.add(profile);
		
		return panel;
	}

	public Account getAccount(){
		return account;
	}
	public void setAccount(Account account){
		this.account = account;
	}

	private JPanel NavBar() {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBounds(130, 30, 900, 50);
		panel.setBackground(new Color(0,0,0,130));
		panel.setVisible(true);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,25,8));

		return panel;
	}
	
	private JPanel NavBarBTN() {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBounds(130, 30, 900, 50);
		panel.setVisible(true);
		panel.setOpaque(false);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,25,10));

		NavBarLabel home = new NavBarLabel("HOME",25);
		home.setPreferredSize(new Dimension(200,30));
		home.setSelected(true);
		home.setFont(setFontSGlacial_BOLD(18));
		
		NavBarLabel categories = new NavBarLabel("CATEGORIES",25);
		categories.setPreferredSize(new Dimension(200,30));
		categories.setForeground(Color.WHITE);
		categories.setFont(setFontSGlacial_BOLD(18));
		
		NavBarLabel overview = new NavBarLabel("OVERVIEW",25);
		overview.setPreferredSize(new Dimension(200,30));
		overview.setForeground(Color.WHITE);
		overview.setFont(setFontSGlacial_BOLD(18));
		
		
		NavBarLabel contact = new NavBarLabel("CONTACT",25);
		contact.setPreferredSize(new Dimension(200,30));
		contact.setForeground(Color.WHITE);
		contact.setFont(setFontSGlacial_BOLD(18));
	
		// ACTIONS
		home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	home.setSelected(true);
        		home.setForeground(Color.BLACK);
        		home.repaint();
            	home.revalidate();
            	
        		categories.setSelected(false);
        		categories.setForeground(Color.WHITE);
        		categories.repaint();
            	categories.revalidate();
        		
        		overview.setSelected(false);
        		overview.setForeground(Color.WHITE);
        		overview.repaint();
            	overview.revalidate();
        		
        		contact.setSelected(false);
        		contact.setForeground(Color.WHITE);
        		contact.repaint();
        		contact.revalidate();
        		
        		ImageIcon icon = new ImageIcon(new ImageIcon("Images/Background-second.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
        		backgroundImage.setIcon(icon);
        		backgroundImage.revalidate();
     
        		outputBody.removeAll();
        		outputBody.add(homeBody);
            	outputBody.revalidate();
            	outputBody.repaint();
            }});
		
		//ACTIONS
		categories.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	categories.setSelected(true);
            	categories.setForeground(Color.BLACK);
            	categories.repaint();
            	categories.revalidate();
            	
        		home.setSelected(false);
        		home.setForeground(Color.WHITE);
        		home.repaint();
            	home.revalidate();
        		
        		overview.setSelected(false);
        		overview.setForeground(Color.WHITE);
        		overview.repaint();
            	overview.revalidate();
            	
        		contact.setSelected(false);
        		contact.setForeground(Color.WHITE);
        		contact.repaint();
        		contact.revalidate();
            	
        		ImageIcon icon = new ImageIcon(new ImageIcon("Images/Background-second.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
        		backgroundImage.setIcon(icon);
        		backgroundImage.revalidate();
        		
            	outputBody.removeAll();
            	outputBody.add(categoriesBody);
            	outputBody.revalidate();
            	outputBody.repaint();
            	
            }});
		
		//ACTIONS
		overview.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	overview.setSelected(true);
            	overview.setForeground(Color.BLACK);
            	overview.repaint();
            	overview.revalidate();
            	
        		home.setSelected(false);
        		home.setForeground(Color.WHITE);
            	home.repaint();
            	home.revalidate();
            
        		categories.setSelected(false);
        		categories.setForeground(Color.WHITE);
            	categories.repaint();
            	categories.revalidate();
        		
        		contact.setSelected(false);
        		contact.setForeground(Color.WHITE);
            	contact.repaint();
        		contact.revalidate();
        		
        		ImageIcon icon = new ImageIcon(new ImageIcon("Images/overview_1stpg.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
        		backgroundImage.setIcon(icon);
        		backgroundImage.revalidate();

        		outputBody.removeAll();
        		outputBody.add(overviewBody);
            	outputBody.revalidate();
            	outputBody.repaint();
            }});
		
		//ACTIONS
		contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	contact.setSelected(true);
            	contact.setForeground(Color.BLACK);
            	contact.repaint();
        		contact.revalidate();
            	
        		home.setSelected(false);
        		home.setForeground(Color.WHITE);
            	home.repaint();
            	home.revalidate();
            	
        		categories.setSelected(false);
        		categories.setForeground(Color.WHITE);
        		categories.repaint();
            	categories.revalidate();
            	
        		overview.setSelected(false);
        		overview.setForeground(Color.WHITE);
        		overview.repaint();
            	overview.revalidate();
            	
            	ImageIcon icon = new ImageIcon(new ImageIcon("Images/contacts.png").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
        		backgroundImage.setIcon(icon);
        		backgroundImage.revalidate();
          	
            	outputBody.removeAll();
            	outputBody.add(contactBody);
            	outputBody.revalidate();
            	outputBody.repaint();           	
            }});
		
    	home.repaint();
    	home.revalidate();
    	
    	categories.repaint();
    	categories.revalidate();
    	
    	overview.repaint();
    	overview.revalidate();
    	
    	contact.repaint();
		contact.revalidate();
		
		panel.add(home);
		panel.add(categories);
		panel.add(overview);
		panel.add(contact);
		return panel;
	}
	
	private JLayeredPane PANE() {
		return this;
	}
	
	private JLabel url() {
		JLabel url = new JLabel("www.gadgetopia.com");
		url.setFont(setFontSGlacial(16));
		url.setBounds(60,570, 200,20);
		
		return url;
	}
	private JPanel Header() {
		JPanel header = new JPanel();
		header.setBackground(new Color(0,0,0,170));
		header.setBounds(0,0,1215,80);
		header.add(LogoName());
		header.setLayout(null);

		return header;
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
			return new Font("Arial", Font.PLAIN,(int) fontSize);
		}
		
	}

}
