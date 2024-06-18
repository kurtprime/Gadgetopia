package mainFrame.Panels.SubPanels;

import mainFrame.Controller.MongoDB;
import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.Cart;
import mainFrame.Panels.Methdos.LightScrollPane;
import mainFrame.Panels.SecondPanel;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyCart extends JPanel {
    Cart[] carts;
    MongoDB mongoDB = new MongoDB(true);
    String username;
    SecondPanel secondPanel;
    Account account;
    JButton removeBTN = new JButton("X");

    public MyCart(Cart[] carts, String username, SecondPanel secondPanel){
        this.carts =carts;
        this.secondPanel = secondPanel;
        this.username = username;
        init();
    }
    private void init(){
        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(Title());
        this.add(labels());
        this.add(chosenProducts());
        this.add(total());
    }
    private JLabel Title(){
        JLabel label = new JLabel("MY CART");
        label.setForeground(new Color(0xE8EAEE));
        label.setFont(setFontSGlacial_BOLD(39));
        label.setBounds(15,20,300,41);
        return label;
    }
    private JPanel labels(){
        JPanel pane = new JPanel();
        pane.setLayout(null);
        pane.setBounds(100,80,1000,30);
        pane.setOpaque(false);

        JLabel products = new JLabel("PRODUCTS:");
        JLabel quantity = new JLabel("QUANTITY:");
        JLabel price = new JLabel("PRICE:");

        products.setForeground(new Color(0xE8EAEE));
        products.setFont(setFontSherif(27));
        products.setBounds(0,0,200,30);

        quantity.setForeground(new Color(0xE8EAEE));
        quantity.setFont(setFontSherif(27));
        quantity.setBounds(400,0,200,30);

        price.setForeground(new Color(0xE8EAEE));
        price.setFont(setFontSherif(27));
        price.setBounds(900,0,200,30);

        pane.add(products);
        pane.add(quantity);
        pane.add(price);
        return pane;
    }

    private LightScrollPane chosenProducts(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(1000,400);
        panel.setOpaque(false);

        if(carts != null) {
            for(Cart cart : carts){
                panel.add(product(cart));
            }
        }

        LightScrollPane scrollPane = new LightScrollPane(panel);
        scrollPane.setOpaque(true);
        scrollPane.setBounds(30,120,1100,400);
        return scrollPane;
    }

    private JPanel total(){
        int totalPrice = 0;
        JPanel pane = new JPanel();
        pane.setOpaque(false);
        pane.setBounds(480,500,300,100);

        for (Cart cart : carts){
            totalPrice += cart.getPrice() * cart.getQuantity();
        }

        JLabel totalCost = new JLabel("TOTAL COST PHP "+totalPrice);
        totalCost.setForeground(Color.white);
        totalCost.setBounds(0,80,200,30);
        totalCost.setFont(setFontSherif(25));

        pane.add(totalCost);
        return pane;
    }

    private JPanel product(Cart cart){
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(1100,100));
        pane.setLayout(null);
        pane.setOpaque(false);

        removeBTN.setBounds(0,40,30,30);
        removeBTN.setForeground(Color.WHITE);
        removeBTN.setFocusPainted(false);
        removeBTN.setBorderPainted(false);
        removeBTN.setContentAreaFilled(false);
        removeBTN.setOpaque(false);

        JLabel imageProduct = new JLabel();
        imageProduct.setBounds(50,0,130,100);
        System.out.println(cart.getPathFile());
        imageProduct.setIcon(simpleResizeImage(cart.getPathFile(),120));

        JLabel quantity = new JLabel(""+ cart.getQuantity());
        quantity.setBounds(470,40,200,30);
        quantity.setFont(setFontSGlacial(26));
        quantity.setForeground(Color.white);

        JLabel price = new JLabel(""+ cart.getPrice());
        price.setBounds(970,40,200,30);
        price.setFont(setFontSGlacial(26));
        price.setForeground(Color.white);

        removeBTN.addActionListener(e->{
            mongoDB.removeCartByName(username, cart.getName());
            secondPanel.setAccount(account(username));
            System.out.println("remove I guess?");
            this.revalidate();
        });

        pane.add(imageProduct);
        pane.add(quantity);
        pane.add(removeBTN);
        pane.add(price);
        return pane;
    }
    public Account account(String name){
        MongoDB acc = new MongoDB(true);
        List<Account> accounts = acc.getAccounts();
        int accountLength = accounts.toArray().length;
        int i = 0;
        for (i = 0; i < accountLength; i++) {
            boolean available = name.equalsIgnoreCase(accounts.get(i).getUsername());
            if(available){
                System.out.println("TRUE");
                return account = accounts.get(i);
            }
        }
        System.out.println("FALSE??");
        return null;
    }

    public JButton getRemoveBTN() {
        return removeBTN;
    }

    private ImageIcon simpleResizeImage(String originalImage, int targetWidth){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(originalImage));
        } catch (IOException e){
            System.err.println(e);
        }
        return new ImageIcon(Scalr.resize(image, targetWidth));
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
}
