import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args){

        Node n1 = new Node(0,0,0, new LinkedList<Edge>());
        Node n2 = new Node(50,50,1, new LinkedList<Edge>());
        Node n3 = new Node(100,100,2, new LinkedList<Edge>());
        Node n4 = new Node(150,150,3, new LinkedList<Edge>());
        Node n5 = new Node(200,200,4, new LinkedList<Edge>());

        LinkedList<Node> nodes = new LinkedList<Node>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);

        Graph g = new Graph(nodes, new LinkedList<Edge>());
        JFrame frame = new JFrame();
        frame.setBounds(0,0,1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);

        for(int i=0;i<nodes.size();i++){
            frame.add(nodes.get(i));
            frame.setVisible(true);
        }

        class JFrameEventListener implements KeyListener, MouseListener, MouseMotionListener {
            boolean shift_down = false;
            Node selected_node = null;

            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e){}

            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){
                double ajr_x = e.getX();
                double ajr_y = e.getY();
                for(int i=0;i<nodes.size();i++){
                    double distance = Math.sqrt(Math.pow(ajr_x-nodes.get(i).getCircle().getCenterX(),2)+Math.pow(ajr_y-nodes.get(i).getCircle().getCenterY(),2));
                    if(distance <= (nodes.get(i).getDiam()/2)){
                        selected_node = nodes.get(i);
                        System.out.println(selected_node.getID());
                    } else {
                        System.out.println(distance);
                        System.out.println("("+ajr_x+", "+ajr_y+")");
                        System.out.println("("+nodes.get(i).getCircle().getCenterX()+", "+nodes.get(i).getCircle().getCenterY()+")");
                    }
                }
            }

            public void mouseReleased(MouseEvent e){
                if(selected_node != null){
                    selected_node = null;
                }
            }
            public void mouseMoved(MouseEvent e){}
            public void mouseDragged(MouseEvent e){}
        }

        JFrameEventListener j = new JFrameEventListener();
        frame.addKeyListener(j);
        frame.addMouseListener(j);
        frame.addMouseMotionListener(j);
    }
}


//Something wrong with the relative coordinates :(