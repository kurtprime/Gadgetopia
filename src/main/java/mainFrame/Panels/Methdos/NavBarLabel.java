package mainFrame.Panels.Methdos;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NavBarLabel extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private boolean selected = false;
	
    public NavBarLabel(String text, int radius) {
        super(text);
        this.radius = radius;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(false); // Ensure the label doesn't paint its background
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint background
        g2.setColor(Color.WHITE);
        if(getSelected()){
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }
   

        // Paint text
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setPaint(Color.WHITE);
        g2.setColor(Color.white);
        if(getSelected()) {
        	g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }
        g2.dispose();
    }

    @Override
    public void setBorder(Border border) {
        // Avoid setting a border directly to ensure rounded corners are maintained
        super.setBorder(new RoundedBorder(radius));
    }

    public void setLabelSize(Dimension size) {
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }
    public boolean getSelected(){
    	return selected;
    }
    public void setSelected(boolean selected){
    	this.selected = selected;
    }

    private class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(Color.WHITE);
            if(getSelected()) {
            	g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }
            g2.dispose();
        }
    }
}
