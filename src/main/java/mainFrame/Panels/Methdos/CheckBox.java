package mainFrame.Panels.Methdos;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {
    private final int border = 4;

    public CheckBox(){
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        Graphics2D g2 = (Graphics2D) graphics;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ly = (getHeight() -16 ) /2;

        if(isSelected()){
            if(isEnabled()){
                g2.setColor(getBackground());
            }else{
                g2.setColor(Color.GRAY);
            }
            g2.fillRoundRect(1, ly, 16,16, border,border );

            //Draw check icon
            int[]  px= {4,8,14,12,8};
            int[] py = {ly+8, ly + 14, ly+5, ly+3, ly+10, ly+6};
            g2.setColor(new Color(0,0,0));
            g2.fillPolygon(px,py,px.length);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(2,ly,14,14,border,border);
        } else{
            g2.setColor(new Color(0xECEDF3));
            g2.fillRect(1,ly,16,16);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(2,ly,14,14,border,border);
        }



    }
}
