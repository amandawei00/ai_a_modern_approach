import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class Node extends JComponent {

    LinkedList<Edge> edges;
    Ellipse2D.Double circle;
    int diam = 28;
    int x, y, id;

    public Node(int x, int y, int id, LinkedList<Edge> edges){
        circle = new Ellipse2D.Double(x, y, diam, diam);
        this.x = x;
        this.y = y;
        this.id = id;
        this.edges = edges;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(circle);
    }

    public Ellipse2D.Double getCircle(){
        return circle;
    }

    public void addEdge(Node b){
        edges.add(new Edge(this, b));
    }

    public int getDiam(){
        return diam;
    }

    public int getID(){
        return id;
    }
}
