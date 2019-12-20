import java.util.ArrayList;

public class Link {
    //A link is defined by the nodes at the two ends, and is distance. It is retrieved when provided the two nodes
    ArrayList<Node> parent_child = new ArrayList<Node>();
    Node parent;
    Node child;
    int distance;

    public Link(Node parent, Node child, int d){
        this.parent = parent;
        this.child = child;
        parent_child.add(parent);
        parent_child.add(child);
        this.distance = d;
    }

    public ArrayList<Node> get_nodes(){
        return parent_child;
    }

    public Node get_parent(){
        return parent;
    }

    public Node get_child(){
        return child;
    }

    public int get_distance(){
        return distance;
    }
}