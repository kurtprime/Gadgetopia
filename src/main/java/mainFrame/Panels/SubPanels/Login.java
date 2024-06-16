package mainFrame.Panels.SubPanels;

import mainFrame.Controller.MongoDB;
import mainFrame.Controller.Objects.Account;
import mainFrame.Panels.Methdos.CheckBox;
import mainFrame.Panels.Methdos.RoundedLabel;
import mainFrame.Panels.Methdos.RoundedLines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Login extends JPanel {
    MongoDB accts = new MongoDB(false);
    List<Account> accounts = accts.getAccounts();
    private Account account;
    public JTextField nameField = null;
    private boolean found = false;
    JLabel loginbtn;

    public Login(){
        login();
    }

    private JPanel pane(){
        return this;
    }
    private void login(){
        this.setBounds(750, 0, 400, 600);
        this.setOpaque(false);
        this.setBackground(Color.RED);
        this.setLayout(null);
        this.setVisible(true);

        ToolTipManager.sharedInstance().setInitialDelay(200);

        JLabel createTitle = new JLabel("LOGIN TO YOUR ACCOUNT");
        createTitle.setFont(setFontSherif(22));
        createTitle.setBounds(60, 20, 300, 25);

        JLabel signUpLabel = new JLabel("LOG IN");
        signUpLabel.setFont(setFontSGlacial_BOLD(28));
        signUpLabel.setBounds(140, 110, 200, 30);

        RoundedLines name = new RoundedLines("", 45);
        name.setBounds(70, 170, 270, 45);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 35));
        nameField.setOpaque(false);
        nameField.setBorder(null);
        nameField.setFont(setFontSherif(16));
        nameField.setToolTipText("USERNAME");
        nameField.setText("USERNAME");
        ImageIcon icon = new ImageIcon(new ImageIcon("Images/user_icon2.png").getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH));
        JLabel ICON = new JLabel();
        ICON.setIcon(icon);
        ICON.setPreferredSize(new Dimension(35,35));
        name.add(ICON);
        name.add(nameField);
        name.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        nameField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (nameField.getText().equals("USERNAME")) {
                    nameField.setText("");
                }
            }
        });

        RoundedLines password = new RoundedLines("", 45);
        password.setBounds(70, 230, 270, 45);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 35));
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        passwordField.setFont(setFontSherif(16));
        passwordField.setToolTipText("PASSWORD");
        passwordField.setText("PASSWORD");
        icon = new ImageIcon(new ImageIcon("Images/lock.png").getImage().getScaledInstance(18,25, Image.SCALE_SMOOTH));
        ICON = new JLabel();
        ICON.setIcon(icon);
        ICON.setPreferredSize(new Dimension(35,35));
        password.add(ICON);
        password.add(passwordField);
        password.setLayout(new FlowLayout());
        passwordField.setEchoChar((char) 0);
        passwordField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String p = String.valueOf(passwordField.getPassword());
                passwordField.setEchoChar('*');
                if (p.equals("PASSWORD")) {
                    passwordField.setText("");
                }

            }
        });
        JLabel Agreement = new JLabel("<html><p>REMEMBER ME</p></html>", SwingConstants.RIGHT);
        Agreement.setBounds(70, 290, 120, 22);
        Agreement.setFont(setFontSherif(13));
        Agreement.setOpaque(false);
        CheckBox check = new CheckBox();
        check.setOpaque(false);
        check.setBounds(10, -3, 30, 30);
        check.setLayout(null);
        Agreement.add(check);

        JLabel forgetPass = new JLabel("<html><p style=\"color: #E80816\">FORGET PASSWORD?</p> </html>", SwingConstants.RIGHT);
        forgetPass.setBounds(220, 290, 128, 22);
        forgetPass.setFont(setFontSherif(13));
        forgetPass.setOpaque(false);

        JLabel invalidInput = new JLabel("<html><p style=\"color: #E80816\">*INVALID INPUT</p></html>", SwingConstants.CENTER);
        invalidInput.setBounds(95, 209, 128, 22);
        invalidInput.setFont(setFontSherif(10));
        invalidInput.setOpaque(false);
        invalidInput.setVisible(false);

        loginbtn = btn("LOGIN", 100, 29, setFontSGlacial_BOLD(27));
        loginbtn.setBounds(90, 330, 240, 40);
        loginbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        loginbtn.setBackground(new Color(0x61627B));
        loginbtn.setForeground(new Color(0x61627B));

        loginbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MongoDB acc = new MongoDB(true);
                accounts = acc.getAccounts();
                int accountLength = accounts.toArray().length;
                int i = 0;
                for (i = 0; i < accountLength; i++) {
                    String p = String.valueOf(passwordField.getPassword());
                    System.out.println(accounts.get(i).getUsername()+", HI "+ accounts.get(i).getPassword());
                    boolean correctUsername = nameField.getText().equalsIgnoreCase(accounts.get(i).getUsername());
                    boolean available = correctUsername && p.equals(accounts.get(i).getPassword());
                    if(available){
                        account = accounts.get(i);
                        break;
                    }
                }
                if(i++ == accountLength) {
                    invalidInput.setVisible(true);
                    found =true;
                    account = null;
                }
            }
        });

        this.add(invalidInput);
        this.add(forgetPass);
        this.add(Agreement);
        this.add(loginbtn);
        this.add(password);
        this.add(name);
        this.add(signUpLabel);
        this.add(createTitle);
    }
    public boolean isFound(){
        return found;
    }

    public JLabel getLoginbtn(){
        return loginbtn;
    }

    public Account getData (){
        return account;
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

    private Font setFontSherif(float fontSize) {
        Font FontSherif;
        try {
            FontSherif = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSerifDisplay-Regular.ttf")).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSerifDisplay-Regular.ttf")));

            return FontSherif;
        } catch (FontFormatException | IOException e) {
            // TODO Auto-generated catch block
            //System.out.println(e);
            return new Font("Arial", Font.PLAIN, (int) fontSize);
        }
    }
    private Font setFontSGlacial_BOLD(float fontSize) {
        Font FontGlacial;
        try {
            FontGlacial = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/GlacialIndifference-Bold.otf")).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/GlacialIndifference-Regular.otf")));

            return FontGlacial;
        } catch (FontFormatException | IOException e) {
            // TODO Auto-generated catch block
            //System.out.println(e);
            return new Font("Arial", Font.PLAIN, (int) fontSize);
        }
    }

}
