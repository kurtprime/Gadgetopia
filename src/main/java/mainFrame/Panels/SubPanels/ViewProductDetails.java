package mainFrame.Panels.SubPanels;

import mainFrame.Controller.MongoDB;
import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.Cart;
import mainFrame.Controller.Objects.ProductDetails;
import mainFrame.Panels.Methdos.RoundedLabel;
import mainFrame.Panels.Methdos.StarComponent;
import mainFrame.Panels.SecondPanel;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ViewProductDetails extends JPanel {
    JPanel userInfo;
    ProductDetails productDetails;
    int quantityItemNumber = 1;
    Account account;
    SecondPanel backHome;
    RoundedLabel backbtn = new RoundedLabel("",40);
    MongoDB mongoDB = new MongoDB(false);


    public  ViewProductDetails(JPanel userInfo , ProductDetails productDetails, SecondPanel backHome, Account account){
        this.account = account;
        this.userInfo = userInfo;
        this.productDetails = productDetails;
        this.backHome = backHome;
        init();
    }
    private void init(){
        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(userInfo);
        details();
    }
    private void details(){
        JLabel detailProduct = new JLabel("PRODUCT DETAILS:");
        detailProduct.setForeground(new Color(0xE8EAEE));
        detailProduct.setFont(setFontSGlacial(25));
        detailProduct.setBounds(5,10,300,26);

        JLabel image1 = new JLabel();
        image1.setIcon(simpleResizeImage(productDetails.getPathFile()[0],360));
        image1.setBounds(20,120,350,350);

        JLabel image2 = new JLabel();
        image2.setIcon(simpleResizeImage(productDetails.getPathFile()[1],105));
        image2.setBounds(380,125,100,100);

        JLabel image3 = new JLabel();
        image3.setIcon(simpleResizeImage(productDetails.getPathFile()[2],105));
        image3.setBounds(380,240,100,100);

        JLabel image4 = new JLabel();
        image4.setIcon(simpleResizeImage(productDetails.getPathFile()[3],105));
        image4.setBounds(380,355,100,100);

        JLabel itemName = new JLabel(productDetails.getName().toUpperCase());
        itemName.setFont(setFontSherif(49));
        itemName.setBounds(510,15,700,50);
        itemName.setForeground(new Color(0xE6E7E8));

        JLabel itemDetail = new JLabel("<html><p>"+ productDetails.getAbout().toUpperCase() +"</p></html>");
        itemDetail.setForeground(Color.white);
        itemDetail.setBounds(510,75,550,150);
        itemDetail.setOpaque(false);
        itemDetail.setFont(setFontSGlacial(18));
        itemDetail.setVerticalTextPosition(JLabel.TOP);
        itemDetail.setVerticalAlignment(JLabel.TOP);
        itemDetail.setHorizontalTextPosition(JLabel.LEFT);

        JLabel price = new JLabel("PHP "+ productDetails.getPrice());
        price.setFont(setFontSherif(49));
        price.setBounds(510,200,300,50);
        price.setForeground(new Color(0xE6E7E8));

        JPanel starReview = new JPanel();
        starReview.setBounds(510,245,300,70);
        double averageReview = calculateAverage(productDetails.getReviews());
        JLabel rating = new JLabel("Rating: "+averageReview+"/"+ productDetails.getReviews().length);
        rating.setPreferredSize(new Dimension(300,22));
        rating.setForeground(new Color(0xFFFFFF));
        rating.setFont(setFontSGlacial(20));
        starReview.add(rating);
        starReview.setOpaque(false);
        starReview.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i <= averageReview; i++) {
            if(i == Math.round(averageReview)){
                starReview.add(new StarComponent(true));
            }else {
                starReview.add(new StarComponent(false));
            }
        }

        JPanel pickColor = new JPanel();
        pickColor.setBounds(510,325,200,70);
        pickColor.setLayout(new FlowLayout(FlowLayout.LEFT));
        pickColor.setOpaque(false);
        JLabel colorLabel = new JLabel("CHOOSE A COLOR:");
        colorLabel.setPreferredSize(new Dimension(200,20));
        colorLabel.setFont(setFontSGlacial(20));
        colorLabel.setForeground(Color.white);
        pickColor.add(colorLabel);
        for(Integer color : productDetails.getColor() ){
            RoundedLabel colour = new RoundedLabel("",25);
            colour.setForeground(new Color(color));
            colour.setBackground(new Color(color));
            colour.setPreferredSize(new Dimension(25,25));
            pickColor.add(colour);
        }

        JPanel quantityPanel = new JPanel();
        quantityPanel.setBounds(510, 380,450,150);
        quantityPanel.setLayout(null);
        quantityPanel.setOpaque(false);
        JLabel quantity = new JLabel("QUANTITY:");
        quantity.setBounds(0,5,100,20);
        quantity.setFont(setFontSGlacial(18));
        quantity.setForeground(Color.white);
        JButton minus = new JButton("-");
        minus.setBounds(10,30,35,35);
        minus.setForeground(Color.WHITE);
        minus.setBorder(new LineBorder(Color.WHITE));
        minus.setFont(setFontSGlacial(25));
        minus.setFocusPainted(false);
        minus.setContentAreaFilled(false);
        JLabel quantityLabel = new JLabel(""+quantityItemNumber, SwingConstants.CENTER);
        quantityLabel.setBounds(45,30,35,35);
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setBorder(new LineBorder(Color.WHITE));
        quantityLabel.setFont(setFontSGlacial(20));
        JButton plus = new JButton("+");
        plus.setBounds(80,30,35,35);
        plus.setForeground(Color.WHITE);
        plus.setBorder(new LineBorder(Color.WHITE));
        plus.setFont(setFontSGlacial(25));
        plus.setFocusPainted(false);
        plus.setContentAreaFilled(false);
        JLabel stocks = new JLabel(productDetails.getStocks()+" STOCKS REMAINING");
        stocks.setFont(setFontSGlacial(15));
        stocks.setForeground(Color.white);
        stocks.setBounds(120,35,205,18);
        quantityPanel.add(stocks);
        quantityPanel.add(quantity);
        quantityPanel.add(minus);
        quantityPanel.add(plus);
        quantityPanel.add(quantityLabel);

        minus.addActionListener(e ->{
            if(quantityItemNumber > 0 && quantityItemNumber <= productDetails.getStocks()){
                quantityItemNumber --;
                quantityLabel.setText(""+quantityItemNumber);
                quantityLabel.revalidate();
            }
        });
        plus.addActionListener(e ->{
            if(quantityItemNumber >= 0 && quantityItemNumber <= productDetails.getStocks()){
                quantityItemNumber ++;
                quantityLabel.setText(""+quantityItemNumber);
                quantityLabel.revalidate();
            }
        });

        JButton addToCart = Button("ADD TO CART");
        addToCart.setBounds(580, 470,200,50);
        addToCart.addActionListener(e->{
            System.out.println("EDI WOW");
            System.out.println(productDetails.getPathFile()[0]+", "+ productDetails.getName());
            try{
                mongoDB.addCartToAccount(backHome.getAccount().getUsername(), new Cart(productDetails.getName(), productDetails.getPathFile()[0], quantityItemNumber, productDetails.getPrice()));
                backHome.setAccount(account(backHome.getAccount().getUsername()));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Please LOGIN first",
                        "Luh", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Success fully been added");
        });

        JButton buyNow = Button("BUY NOW");
        buyNow.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "Okie",
                    "Dokie", JOptionPane.PLAIN_MESSAGE);
        });
        buyNow.setBounds(800, 470,200,50);

        this.add(addToCart);
        this.add(buyNow);
        this.add(quantityPanel);
        this.add(starReview);
        this.add(pickColor);
        this.add(image1);
        this.add(image2);
        this.add(image3);
        this.add(image4);
        this.add(itemName);
        this.add(itemDetail);
        this.add(price);
        this.add(url());
        this.add(backButton());
        this.add(detailProduct);
    }

    private JButton Button(String title){
        JButton button = new JButton(title);
        button.setFont(setFontSGlacial_BOLD(18));
        button.setBackground(new Color(0,0,0));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
    public JComponent backButton(){
        JLabel back = new JLabel("BACK");
        back.setPreferredSize(new Dimension(48,20));
        back.setOpaque(false);
        back.setFont(setFontSGlacial(20));
        backbtn.add(back);
        backbtn.setBounds(1000,545,90,40);
        backbtn.setHorizontalAlignment(SwingConstants.CENTER);
        backbtn.setBackground(new Color(0xCCCED2));
        backbtn.setForeground(new Color(0xCCCED2));
        backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbtn.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));

        backbtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                backHome.backHome();
            }
        });

        return backbtn;
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
    private JLabel url() {
        JLabel url = new JLabel("www.gadgetopia.com");
        url.setFont(setFontSGlacial(16));
        url.setBounds(50,555, 200,20);

        return url;
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

    private double calculateAverage(Integer[] ratings) {
        if (ratings == null || ratings.length == 0) {
            throw new IllegalArgumentException("The ratings array cannot be null or empty");
        }

        double sum = 0;
        for (double rating : ratings) {
            sum += rating;
        }

        return sum / ratings.length;
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
}
