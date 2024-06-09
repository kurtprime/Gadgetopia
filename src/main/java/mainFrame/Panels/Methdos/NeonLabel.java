package mainFrame.Panels.Methdos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NeonLabel extends JLabel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NeonLabel(String text) {
        super(text);
        setForeground(Color.WHITE);
        setFont(setFontSherif(40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smoother text
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set the neon glow color and the text color
        Color neonColor = Color.CYAN;
        Color textColor = getForeground();
        
        // Get the text and font metrics
        String text = getText();
        FontMetrics fm = g2d.getFontMetrics(getFont());
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int textX = (getWidth() - textWidth) / 2;
        int textY = (getHeight() + textHeight) / 2 - fm.getDescent();

        // Draw the glow effect by repeatedly drawing the text with increasing stroke sizes
        for (int i = 0; i < 15; i++) {
            float alpha = (15 - i) / 15f; // decrease the alpha value for each layer
            g2d.setColor(new Color(neonColor.getRed(), neonColor.getGreen(), neonColor.getBlue(), (int)(alpha * 255)));
            g2d.setStroke(new BasicStroke(10 + i * 2));
            g2d.drawString(text, textX, textY);
        }

        // Draw the bright outline
        g2d.setColor(neonColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawString(text, textX, textY);

        // Draw the actual text on top
        g2d.setColor(textColor);
        g2d.drawString(text, textX, textY);

        g2d.dispose();
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
			System.out.println(e);
			return new Font("Arial", Font.PLAIN,(int) fontSize);
		}
	}
	
    
}
