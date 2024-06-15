package mainFrame.Panels.SubPanels;

import javax.swing.*;
import java.awt.*;

public class UserInfo extends JPanel {
    public  UserInfo(){
        info();
    }
    private void info(){
        this.setBounds(750, 0, 400, 600);
        this.setOpaque(true);
        this.setBackground(Color.RED);
        this.setLayout(null);
        this.setVisible(true);
    }
}
