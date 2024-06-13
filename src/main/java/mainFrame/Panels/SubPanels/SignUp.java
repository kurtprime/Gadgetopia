package mainFrame.Panels.SubPanels;

import mainFrame.Controller.MongoAdd;
import mainFrame.Controller.MongoDB;
import mainFrame.Controller.Objects.Account;
import mainFrame.Panels.Methdos.CheckBox;
import mainFrame.Panels.Methdos.RoundedLabel;
import mainFrame.Panels.Methdos.RoundedLines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends JPanel {
    MongoDB acc = new MongoDB(false);
    List<Account> accounts = acc.getAccounts();  //= acc.getAccounts();
    private Account account;
    private JLabel signUpBtn;
    private boolean isAllCorrect = true;

    public SignUp() {

        signUpPane();
    }

    private void signUpPane() {

        this.setBounds(750, 0, 400, 600);
        this.setOpaque(false);
        this.setBackground(Color.RED);
        this.setLayout(null);

        ToolTipManager.sharedInstance().setInitialDelay(200);

        JLabel createTitle = new JLabel("CREATE AN ACCOUNT");
        createTitle.setFont(setFontSherif(22));
        createTitle.setBounds(80, 20, 300, 25);
//
        JLabel signUpLabel = new JLabel("SIGN UP");
        signUpLabel.setFont(setFontSGlacial_BOLD(28));
        signUpLabel.setBounds(140, 110, 200, 30);

        RoundedLines name = new RoundedLines("", 45);
        name.setBounds(70, 170, 270, 45);
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(230, 35));
        nameField.setOpaque(false);
        nameField.setBorder(null);
        nameField.setFont(setFontSherif(16));
        nameField.setToolTipText("NAME");
        nameField.setText("NAME");
        name.add(nameField);
        name.setLayout(new FlowLayout());
        nameField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (nameField.getText().equals("NAME")) {
                    nameField.setText("");
                }
            }
        });

        RoundedLines username = new RoundedLines("", 45);
        username.setBounds(70, 230, 270, 45);
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(230, 35));
        usernameField.setOpaque(false);
        usernameField.setBorder(null);
        usernameField.setFont(setFontSherif(16));
        usernameField.setToolTipText("USERNAME");
        usernameField.setText("USERNAME");
        username.add(usernameField);
        username.setLayout(new FlowLayout());
        usernameField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (usernameField.getText().equals("USERNAME")) {
                    usernameField.setText("");
                }
            }
        });

        RoundedLines email = new RoundedLines("", 45);
        email.setBounds(70, 290, 270, 45);
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(230, 35));
        emailField.setOpaque(false);
        emailField.setBorder(null);
        emailField.setFont(setFontSherif(16));
        emailField.setToolTipText("EMAIL");
        emailField.setText("EMAIL");
        email.add(emailField);
        email.setLayout(new FlowLayout());
        emailField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (emailField.getText().equals("EMAIL")) {
                    emailField.setText("");
                }
            }
        });

        RoundedLines password = new RoundedLines("", 45);
        password.setBounds(70, 350, 270, 45);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(230, 35));
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        passwordField.setFont(setFontSherif(16));
        passwordField.setToolTipText("PASSWORD");
        passwordField.setText("PASSWORD");
        password.add(passwordField);
        password.setLayout(new FlowLayout());
        passwordField.setEchoChar((char) 0);
        passwordField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String p = String.valueOf(passwordField.getPassword());
                System.out.println(p);
                if (p.equals("PASSWORD")) {
                    passwordField.setText("");

                }
                passwordField.setEchoChar('*');
            }
        });

        RoundedLines rePass = new RoundedLines("", 45);
        rePass.setBounds(70, 410, 270, 45);
        JPasswordField rePassField = new JPasswordField();
        rePassField.setPreferredSize(new Dimension(230, 35));
        rePassField.setOpaque(false);
        rePassField.setBorder(null);
        rePassField.setFont(setFontSherif(16));
        rePassField.setToolTipText("CONFIRM PASSWORD");

        rePassField.setText("CONFIRM PASSWORD");

        rePass.add(rePassField);
        rePass.setLayout(new FlowLayout());
        rePassField.setEchoChar((char) 0);
        rePassField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String p = String.valueOf(rePassField.getPassword());
                System.out.println(p);
                if (p.equals("CONFIRM PASSWORD")) {
                    rePassField.setText("");
                }
                rePassField.setEchoChar('*');
            }
        });

        JLabel Agreement = new JLabel("<html><p>I agree with <span style=\"color: #E80816\">privacy</span> and <span style=\"color: #E80816\">policy</span> </p> </html>", SwingConstants.RIGHT);
        Agreement.setBounds(90, 470, 220, 22);
        Agreement.setFont(setFontSherif(13));
        Agreement.setOpaque(false);
        CheckBox check = new CheckBox();
        check.setOpaque(false);
        check.setBounds(10, -3, 30, 30);
        check.setLayout(null);
        Agreement.add(check);

        signUpBtn = btn("SIGN UP", 110, 29, setFontSGlacial_BOLD(27));
        signUpBtn.setBounds(90, 510, 240, 40);
        signUpBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        signUpBtn.setBackground(new Color(0x61627B));
        signUpBtn.setForeground(new Color(0x61627B));

        JLabel notValidName = redFlag("Invalid Name");
        notValidName.setBounds(88, 209, 128, 22);
        JLabel notValidUsername = redFlag("Invalid UserName");
        notValidUsername.setBounds(88, 269, 128, 22);
        JLabel notValidEmail = redFlag("Invalid Email");
        notValidEmail.setBounds(88, 329, 128, 22);
        JLabel notValidPassword = redFlag("Password must have a letter, a number");
        notValidPassword.setBounds(88, 389, 328, 22);
        JLabel notTheSamePassword = redFlag("Password does not match");
        notTheSamePassword.setBounds(88, 449, 128, 22);
        JLabel whyNot = redFlag("Payag kana please");
        whyNot.setBounds(95, 485, 128, 22);

        signUpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isAllCorrect=true;
                String name = nameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirmPass = String.valueOf(rePassField.getPassword());

                notValidName.setVisible(false);
                notValidUsername.setVisible(false);
                notValidEmail.setVisible(false);
                notValidPassword.setVisible(false);
                notTheSamePassword.setVisible(false);
                whyNot.setVisible(false);
                if(!validateName(name) || name.equals("NAME")){
                    isAllCorrect=false;
                    notValidName.setVisible(true);
                }
                if(!validateUsername(username) || username.equals("USERNAME")){
                    isAllCorrect=false;
                    notValidUsername.setVisible(true);
                }else {
                    for (int i = 0; i < accounts.toArray().length ; i++) {
                        String userName = accounts.get(i).getUsername().toLowerCase();
                        if(username.toLowerCase().equals(userName)){
                            System.out.println("username already exist");
                            isAllCorrect=false;
                            notValidUsername.setText("<html><p style=\"color: #E80816\">*Username Already Exist</p></html>");
                            notValidUsername.setVisible(true);
                        }
                    }
                }
                if(!validateEmail(email)){
                    isAllCorrect=false;
                    notValidEmail.setVisible(true);

                }
                if(!validatePassword(password)){
                    isAllCorrect=false;
                    notValidPassword.setVisible(true);
                }
                if(!validateConfirm(password, confirmPass)){
                    isAllCorrect=false;
                    notTheSamePassword.setVisible(true);
                }
                if(!check.isSelected()){
                    isAllCorrect=false;
                    whyNot.setVisible(true);
                }
                if(isAllCorrect){
                    new MongoAdd(username, name, email, password);
                    accounts = new MongoDB(true).getAccounts();
                }
            }

        });

        this.add(whyNot);
        this.add(notValidName);
        this.add(notValidUsername);
        this.add(notValidEmail);
        this.add(notValidPassword);
        this.add(notTheSamePassword);
        this.add(signUpBtn);
        this.add(Agreement);
        this.add(rePass);
        this.add(password);
        this.add(username);
        this.add(email);
        this.add(name);
        this.add(signUpLabel);
        this.add(createTitle);
    }

    private JLabel redFlag(String input){
        JLabel invalidInput = new JLabel("<html><p style=\"color: #E80816\">*"+input+"</p></html>", SwingConstants.CENTER);
        invalidInput.setFont(setFontSherif(10));
        invalidInput.setOpaque(false);
        invalidInput.setBackground(Color.GRAY);
        invalidInput.setHorizontalAlignment(SwingConstants.LEFT);
        invalidInput.setVisible(false);

        return invalidInput;
    }

    private boolean validateName(String name){
        Pattern pattern = Pattern.compile("^((?=.{1,29}$)[A-Z]\\w*(\\s[A-Z]\\w*)*)$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    private boolean validateUsername(String username){
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_.-]{3,}");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    private boolean validateEmail(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);

        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        String regEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,20}$";

        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
    private boolean validateConfirm(String password, String confirmPassword){
        return password.equals(confirmPassword);
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

    public JLabel signUpBtn(){
        return signUpBtn;
    }
    public boolean validSignup(){
        return isAllCorrect;
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
            System.out.println(e);
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