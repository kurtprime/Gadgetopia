package mainFrame.Panels.Methdos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
 
import javax.swing.JComponent;
 
public class Lines extends JComponent {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, xstart, ystart, xend, yend;
    private static Color basecolor = new Color(0xeeeeee);
    private static BasicStroke str = new BasicStroke(2 , BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
 
    // constructor
    public Lines( int id, int xstart, int ystart, int xend, int yend ) {
        this.id = id;
        this.setNewCoords(xstart, ystart, xend, yend);
    }
     
    // the line should get changed through this method
    public void setNewCoords(int xstart, int ystart, int xend, int yend) {
        this.xstart = xstart;
        this.ystart = ystart;
        this.xend = xend;
        this.yend = yend;
        // comment in the line below to make the lines appear
//      this.setSize(Math.max(this.xstart, this.xend), Math.max(this.ystart, this.yend));
    }
     
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Lines.basecolor);
        g2d.setStroke(Lines.str);
        g2d.drawLine( this.xstart, this.ystart, this.xend, this.yend );
        System.out.println("SimpleLine #"+this.id+" values are ("
              +this.xstart+","+this.ystart+") to ("
              +this.xend+","+this.yend+") .");
    }

	public static BasicStroke getStr() {
		return str;
	}

	public static void setStr(BasicStroke str) {
		Lines.str = str;
	}

	public static Color getBasecolor() {
		return basecolor;
	}

	public static void setBasecolor(Color basecolor) {
		Lines.basecolor = basecolor;
	}
}