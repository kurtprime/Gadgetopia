package mainFrame;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainFrame.Panels.FirstPanel;
public class MainFrame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	Font FontSherif;
	Font FontGlacial;
	int FontColor = 0xE8EAEE;
	
	int width;
	int height;
	public MainFrame() {
		frame();
	}

	public MainFrame(String s){}

	private void  frame()  {
		this.setTitle("GADGETOPIA");
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setSize(1215,734);
		width = this.getWidth();
		height = this.getHeight();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		Image icon = Toolkit.getDefaultToolkit().getImage("Images/titleIcon.jpg");  
		this.setIconImage(icon);
		FirstPanel first = new FirstPanel();
		first.setWidthAndHeight(width, height);

		this.add(first);
		
		this.setVisible(true);
	}
	
	public static JFrame getMainFrame(){
        return new MainFrame();
	}

}
