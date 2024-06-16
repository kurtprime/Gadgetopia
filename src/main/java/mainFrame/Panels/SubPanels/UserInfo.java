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
    JLabel settingLabel;
    RoundedLabel btn = backHome();
    private final JPanel rightSide = rightSide();
    private final JPanel leftSideAccount = leftSideAccount();
    public  UserInfo(Account account){
        this.account = account;
        info();
    }
    private void info(){
        this.setOpaque(false);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(leftSideAccount, BorderLayout.WEST);
        this.add(rightSide, BorderLayout.CENTER);
    }
    private JLabel settingIcon(){
        settingLabel = new JLabel();
        ImageIcon setting = new ImageIcon(new ImageIcon("Images/setting.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
        settingLabel.setIcon(setting);
        settingLabel. setBounds(700,30,40,40);
        settingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        settingLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Pane().remove(leftSideAccount);
                Pane().remove(rightSide);
                Pane().add(leftSideSetting(), BorderLayout.WEST);
                Pane().add(rightSideSetting(), BorderLayout.CENTER);
            }});

        return settingLabel;
    }
    public JLabel getSettingIcon(){
        return settingLabel;
    }
    private UserInfo Pane(){
        return this;
    }

    private JPanel leftSideSetting(){
        JPanel settingPane = new JPanel();
        settingPane.setLayout(null);
        settingPane.setOpaque(false);
        settingPane.setPreferredSize(new Dimension(400,0));
        settingPane.setBackground(Color.gray);

        JLabel titleSetting = new JLabel("MY ACCOUNT");
        titleSetting.setFont(setFontSGlacial_BOLD(37));
        titleSetting.setBounds(20,15,300,37);
        titleSetting.setForeground(new Color(0xE8EAEE));

        JPanel account = accountSettings();
        account.setBounds(0,60,400,250);

        settingPane.add(account);
        settingPane.add(titleSetting);
        return settingPane;
    }

    private JPanel accountSettings(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,300));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel titleName = new JLabel("Account");
        titleName.setFont(setFontSGlacial(18));
        titleName.setForeground(Color.WHITE);
        titleName.setPreferredSize(new Dimension(200,20));


        panel.add(titleName);
        return panel;
    }

    private JPanel option(String pathFile, String name, int x, int y){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,100));

        JLabel label = new JLabel(name);
        ImageIcon icon = new ImageIcon(new ImageIcon(pathFile).getImage().getScaledInstance(x,y, Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.setFont(setFontSherif(24));
        label.setForeground(new Color(0xE8EAEE));


        return panel;
    }

    private JPanel rightSideSetting(){
        JPanel rightSide = new JPanel();
        rightSide.setLayout(null);
        rightSide.setVisible(true);
        rightSide.setOpaque(false);

        rightSide.add(btn);

        return rightSide;
    }
    private  JPanel rightSide(){
        JPanel rightSide = new JPanel();
        rightSide.setLayout(null);
        rightSide.setVisible(true);
        rightSide.setOpaque(false);

        rightSide.setBackground(Color.BLACK);
        rightSide.add(btn);

        JLabel shopHistory = new JLabel("SHOPPING HISTORY");
        shopHistory.setFont(setFontSherif(27));
        shopHistory.setForeground(new Color(0xE8EAEE));
        shopHistory.setBounds(30,30,270,27);

        JPanel moreInfo = new JPanel();
        moreInfo.setBounds(50,70,700,520);
        moreInfo.setBackground(Color.red);
        moreInfo.setOpaque(false);
        moreInfo.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
        moreInfo.add(myPurchases());
        moreInfo.add(otherActivity());
        moreInfo.add(collectRewards());

        rightSide.add((settingIcon()));
        rightSide.add(moreInfo);
        rightSide.add(shopHistory);
        return rightSide;
    }

    private JPanel myPurchases(){
        JPanel box = new JPanel();
        box.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        box.setOpaque(false);
        box.setPreferredSize(new Dimension(700,150));

        JLabel name = new JLabel("MY PURCHASES");
        name.setPreferredSize(new Dimension(800,30));
        ImageIcon arrow = new ImageIcon(new ImageIcon("Images/yeah.png").getImage().getScaledInstance(24,30, Image.SCALE_SMOOTH));
        name.setIcon(arrow);
        name.setForeground(new Color(0xE8EAEE));
        name.setFont(setFontSherif(23));

        box.add(name);
        box.add(iconLabel("TO PAY", "Images/wa.png", 50,50));
        box.add(iconLabel("TO SHIP", "Images/dw.png", 50,40));
        box.add(iconLabel("TO DELIVER", "Images/sh.png", 50,40));
        box.add(iconLabel("COMPLETED", "Images/ch.png", 50,50));
        box.add(iconLabel("TO RATE", "Images/ra.png", 50,50));
        return box;
    }
    private JPanel otherActivity(){
        JPanel box = new JPanel();
        box.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
        box.setOpaque(false);
        box.setPreferredSize(new Dimension(700,150));

        JLabel name = new JLabel("OTHER ACTIVITIES");
        name.setPreferredSize(new Dimension(700,30));
        ImageIcon arrow = new ImageIcon(new ImageIcon("Images/yeah.png").getImage().getScaledInstance(24,30, Image.SCALE_SMOOTH));
        name.setIcon(arrow);
        name.setForeground(new Color(0xE8EAEE));
        name.setFont(setFontSherif(23));

        box.add(name);
        box.add(iconLabel("LIKED PRODUCTS", "Images/he.png", 50,45));
        box.add(iconLabel("FOLLOWED SHOPS", "Images/ho.png", 50,50));
        box.add(iconLabel("MY CART", "Images/com.png", 50,45));
        box.add(iconLabel("SAVED PRODUCTS", "Images/co.png", 40,50));

        return box;
    }
    private JPanel collectRewards(){
        JPanel box = new JPanel();
        box.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        box.setOpaque(false);
        box.setPreferredSize(new Dimension(700,150));

        JLabel name = new JLabel("COLLECTED REWARDS");
        name.setPreferredSize(new Dimension(800,30));
        ImageIcon arrow = new ImageIcon(new ImageIcon("Images/yeah.png").getImage().getScaledInstance(24,30, Image.SCALE_SMOOTH));
        name.setIcon(arrow);
        name.setForeground(new Color(0xE8EAEE));
        name.setFont(setFontSherif(23));

        box.add(name);
        box.add(iconLabel("SHOP VOUCHERS", "Images/j.png", 70,35));
        box.add(iconLabel("COINS", "Images/cc.png", 55,55));

        return box;
    }

    private JLabel iconLabel(String name, String pathFile, int x, int y){
        JLabel label = new JLabel(name);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(setFontSGlacial(16));
        label.setForeground(Color.white);
        label.setPreferredSize(new Dimension(140,90));
        ImageIcon icon = new ImageIcon(new ImageIcon(pathFile).getImage().getScaledInstance(x,y, Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return label;
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

        JLabel edit = new JLabel("EDIT PROFILE");
        ImageIcon pencil = new ImageIcon(new ImageIcon("Images/pen.png").getImage().getScaledInstance(44,50, Image.SCALE_SMOOTH));
        edit.setIcon(pencil);
        edit.setFont(new Font("sans", Font.PLAIN, 15));
        edit.setHorizontalAlignment(SwingConstants.LEFT);
        edit.setForeground(Color.white);
        edit.setBounds(20,55, 150,50);

        JLabel userIcon = new JLabel("@"+ "BASTA" /* account.getUsername() */);
        ImageIcon icon = new ImageIcon(new ImageIcon("Images/hehe.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
        userIcon.setIcon(icon);
        userIcon.setOpaque(false);
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

        myAccount.add(edit);
        myAccount.add(userDetails);
        myAccount.add(userIcon);
        myAccount.add(titleAccount);
        myAccount.add(url());
        return myAccount;
    }



    private RoundedLabel backHome(){
        btn = new RoundedLabel("",40);
        JLabel text = new JLabel("BACK TO HOME");
        text.setPreferredSize(new Dimension(130,20));
        text.setOpaque(false);
        text.setFont(setFontSGlacial(18));
        btn.add(text);
        btn.setBounds(600,545,180,40);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setBackground(new Color(0xCCCED2));
        btn.setForeground(new Color(0xCCCED2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println(account);
            }});

        return btn;
    }
    public JLabel getBackHome(){
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
