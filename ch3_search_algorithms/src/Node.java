import java.util.ArrayList;

public class Node {
    boolean flag; //t/f end, n0 will always be the start
    int index;
    int distance; // from root node
    boolean examined;
    ArrayList<Node> neighbors;

    public Node(int n, int distance, boolean flag){
        this.index = n;
        this.neighbors = new ArrayList<Node>();
        this.distance = distance;
        this.flag = flag;
        this.examined = false;
    }

    public Node(int n, ArrayList<Node> neighbors, boolean flag){
        this.index=n;
        this.neighbors=neighbors;
        this.flag = flag;
    }

    public boolean flag(){
        return flag;
    }

    public void add_neighbors(Node new_node){
        neighbors.add(new_node);
    }

    public int get_index(){
        return index;
    }
    public ArrayList<Node> get_neighbors(){
        return neighbors;
    }

    public void print_neighbors(){
        System.out.print(Integer.toString(index)+ ": ");
        for(int i=0;i<neighbors.size();i++){
            System.out.print(Integer.toString(neighbors.get(i).get_index()) + " ");
        }
        System.out.println();
    }

    public int get_distance(){
        return distance;
    }

    public void set_examined(boolean new_state){
        examined = new_state;
    }

    public boolean is_examined() {
        return examined;
    }

//given a list of nodes adjacent to this node, this method will return a new list of nodes from the original list which have not yet been examined by the searcher
    public ArrayList<Node> unexamined(ArrayList<Node> potentials){
        ArrayList<Node> unexamined_list = new ArrayList<Node>();
        for(int i=0;i<potentials.size();i++){
            if(potentials.get(i).is_examined()==false){
                unexamined_list.add(potentials.get(i));
            }
        }
        return unexamined_list;
    }

}
