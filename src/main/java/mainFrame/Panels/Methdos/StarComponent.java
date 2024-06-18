package mainFrame.Panels.Methdos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class StarComponent extends JComponent {
    private boolean halfStar;

    public StarComponent(boolean halfStar) {
        this.halfStar = halfStar;
        setPreferredSize(new Dimension(40, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable antialiasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define the star shape
        GeneralPath star = createStar(20, 20, 18, 7, 5);

        if (halfStar) {
            // Clip to the left half of the component
            g2d.clipRect(0, 0, getWidth() / 2, getHeight());
        }

        // Draw the star
        g2d.setColor(Color.WHITE);
        g2d.fill(star);

        // Optional: Adding a slight stroke to enhance smoothness
        g2d.setColor(new Color(0, 0, 0, 50)); // Semi-transparent black for smoother edges
        g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(star);
    }

    private GeneralPath createStar(double centerX, double centerY, double outerRadius, double innerRadius, int points) {
        GeneralPath path = new GeneralPath();
        double angleIncrement = 2 * Math.PI / points;
        double startAngle = -Math.PI / 2; // Start from the top

        for (int i = 0; i < points; i++) {
            double outerAngle = startAngle + i * angleIncrement;
            double innerAngle = outerAngle + angleIncrement / 2;

            double outerX = centerX + Math.cos(outerAngle) * outerRadius;
            double outerY = centerY + Math.sin(outerAngle) * outerRadius;
            double innerX = centerX + Math.cos(innerAngle) * innerRadius;
            double innerY = centerY + Math.sin(innerAngle) * innerRadius;

            if (i == 0) {
                path.moveTo(outerX, outerY);
            } else {
                path.lineTo(outerX, outerY);
            }
            path.lineTo(innerX, innerY);
        }

        path.closePath();
        return path;
    }
/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Star and Half-Star Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            // Full star
            StarComponent fullStar = new StarComponent(false);
            frame.add(fullStar);

            // Half star
            StarComponent halfStar = new StarComponent(true);
            frame.add(halfStar);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


 */

}
