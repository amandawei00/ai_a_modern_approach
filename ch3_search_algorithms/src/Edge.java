import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Edge extends JComponent {

    Line2D.Double line;

    public Edge(Node a, Node b){
        line = new Line2D.Double(a.getCircle().getCenterX(), a.getCircle().getCenterY(), b.getCircle().getCenterX(), b.getCircle().getCenterY());

    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(line);
    }
}
