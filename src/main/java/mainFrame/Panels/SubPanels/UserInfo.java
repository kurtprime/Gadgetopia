package mainFrame.Panels.SubPanels;

import mainFrame.Controller.Objects.Account;
import mainFrame.Panels.Methdos.RoundedLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class UserInfo extends JPanel {
    Account account;

    public  UserInfo(Account account){
        this.account = account;
        info();
    }
    private void info(){
        this.setOpaque(false);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(leftSideAccount(), BorderLayout.WEST);
        this.add(rightSide(), BorderLayout.EAST);

    }
    private  JPanel rightSide(){
        JPanel rightSide = new JPanel();
        rightSide.setLayout(null);
        rightSide.setVisible(true);
        rightSide.setOpaque(false);
        rightSide.setPreferredSize(new Dimension(1000,0));
        rightSide.setBackground(Color.BLACK);
        rightSide.add(backHome());

        return rightSide;
    }
    private JPanel leftSideAccount(){
        JPanel myAccount = new JPanel();
        myAccount.setLayout(null);
        myAccount.setOpaque(false);
        myAccount.setPreferredSize(new Dimension(400,0));
        myAccount.setBackground(Color.gray);

        JLabel titleAccount = new JLabel("MY ACCOUNT");
        titleAccount.setFont(setFontSGlacial_BOLD(37));
        titleAccount.setBounds(20,15,300,37);
        titleAccount.setForeground(new Color(0xE8EAEE));

        //JLabel userIcon = new JLabel();
        JLabel userIcon = new JLabel("@"+ "BASTA" /* account.getUsername() */);
        ImageIcon icon = new ImageIcon(new ImageIcon("Images/hehe.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
        userIcon.setIcon(icon);
        userIcon.setOpaque(true);
        userIcon.setFont(new Font("sans",Font.BOLD,21));
        userIcon.setBackground(Color.red);
        userIcon.setForeground(new Color(0xE8EAEE));
        userIcon.setHorizontalAlignment(SwingConstants.LEFT);
        userIcon.setBounds(20,130,300,50);

        JPanel userDetails = new JPanel();
        userDetails.setOpaque(false);
        userDetails.setBounds(20,180,400,420);
        userDetails.setVisible(true);
        userDetails.setLayout(new FlowLayout(FlowLayout.LEFT,5,23));
        userDetails.add(personalInfo("NAME","Kurt"));
        userDetails.add(personalInfo("AGE","18"));
        userDetails.add(personalInfo("GENDER","ATTACK HELICOPTER"));
        userDetails.add(personalInfo("BIRTHDAY","NOVEMBER 8, 2019"));
        userDetails.add(personalInfo("ADDRESS","SA EARTH"));
        userDetails.add(personalInfo("EMAIL","Kurt@gmail.com"));
        userDetails.add(personalInfo("PHONE NUMBER","328959009"));

        myAccount.add(userDetails);
        myAccount.add(userIcon);
        myAccount.add(titleAccount);
        myAccount.add(url());
        return myAccount;
    }
    public JLabel backHome(){
        RoundedLabel btn = new RoundedLabel("",40);
        JLabel text = new JLabel("BACK TO HOME");
        text.setPreferredSize(new Dimension(130,20));
        text.setOpaque(false);
        text.setFont(setFontSGlacial(18));
        btn.add(text);
        btn.setBounds(780,545,180,40);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setBackground(new Color(0xCCCED2));
        btn.setForeground(new Color(0xCCCED2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(account);
            }});

        return btn;
    }
    private JLabel personalInfo(String title, String ans){
        JLabel label = new JLabel(title+": "+ans);
        label.setFont(setFontSherif(24));
        label.setForeground(new Color(0xE8EAEE));
        label.setPreferredSize(new Dimension(400,25));

        return label;
    }
    private JLabel url() {
        JLabel url = new JLabel("www.gadgetopia.com");
        url.setFont(setFontSGlacial(16));
        url.setBounds(50,553    , 200,20);
        url.setForeground(new Color(0xFFFFFF));
        return url;
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
            //System.out.println(e);
            return new Font("Arial", Font.PLAIN,(int) fontSize);
        }

    }

}
