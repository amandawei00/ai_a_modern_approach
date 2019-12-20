import java.util.ArrayList;

//A graph is a collection of nodes and the links between them
public class Graph {
    ArrayList<Node> nodes;
    ArrayList<Link> links;
    public Graph(ArrayList<Node> n, ArrayList<Link> l){
        this.nodes = n;
        this.links = l;
    }


    //Given two nodes, identifies the link that connects them
    public Link get_link(ArrayList<Node> given_nodes){
        for(int i=0;i<links.size();i++){
            if (links.get(i).get_nodes().containsAll(given_nodes) && given_nodes.containsAll(links.get(i).get_nodes())) {
                return links.get(i);
            }
        }
        return null;
    }

    //Given two nodes, calls the get_link method to identify the link, and then gets the cost to take this path
    public int get_distance(ArrayList<Node> given_nodes){
        return this.get_link(given_nodes).get_distance();
    }

    //breadth-first search
    public Node breadth_first(){
        Node stem;
        Node first = nodes.get(0);
        ArrayList<Node> on_hold = new ArrayList<Node>();
        ArrayList<Node> examined = new ArrayList<Node>();
        on_hold.add(first);
        while(on_hold.size()>0){
            stem = on_hold.get(0);
            //System.out.print(stem.get_index() + " ");
            if(stem.flag()==true){
                return stem;
            }
            for(int i=0;i<stem.get_neighbors().size();i++) {
                if (stem.get_neighbors().get(i).flag() == true) {
                    return stem.get_neighbors().get(i);
                } else if ((examined.contains(stem.get_neighbors().get(i)) == false) && (on_hold.contains(stem.get_neighbors().get(i)) == false)){
                    on_hold.add(stem.get_neighbors().get(i));
                }
            }
            on_hold.remove(stem);
            examined.add(stem);
            /*for(int i=0;i<on_hold.size();i++){
                System.out.print(on_hold.get(i).get_index()+ " ");
            }
            System.out.println(" ");*/
        }
        return null;
    }

    public Node depth_first(Node start){
        //need: examined_list, recursive function (input is number of unexamined neighbors)
        if(start.flag()) return start;
        else {
            ArrayList<Node> unexamined_neighbors = start.get_neighbors();
            ArrayList<Node> examined = new ArrayList<Node>();
            examined.add(start);
            return recursive_call(unexamined_neighbors,examined);
        }
    }

    public int number_unexamined(Node n, ArrayList<Node> examined){
        int count = 0;
        for(int i=0;i<n.get_neighbors().size();i++){
            if(!examined.contains(n.get_neighbors().get(i))) count++;
        }
        return count;
    }
    public Node recursive_call(ArrayList<Node> on_hold, ArrayList<Node> examined){
        //System.out.print(on_hold.get(0).get_index()+ ": ");
        if(on_hold.get(0).flag()) return on_hold.get(0);
        else if(this.number_unexamined(on_hold.get(0),examined)==0){
            examined.add(on_hold.get(0));
            on_hold.clear();
        } else {
            examined.add(on_hold.get(0));
            on_hold.clear();
            for(int i=0;i<examined.get(examined.size()-1).get_neighbors().size();i++) {
                if(!examined.contains(examined.get(examined.size() - 1).get_neighbors().get(i))) {
                    //System.out.print(examined.get(examined.size()-1).get_neighbors().get(i).get_index()+ " ");
                    on_hold.add(examined.get(examined.size() - 1).get_neighbors().get(i));
                }
            }
            //System.out.println();
            return recursive_call(on_hold,examined);
        }
        return null;
    }

    public Node uniform_cost(){
        return null;
    }
    public Node iterative_deepening_depth_first(){
        return null;
    }

    public Node bidirectional(){
        return null;
    }

    public Node greedy_best_first(Node start){
        if(start.flag()==true) return start;
        else return greedy_recursion(start);
    }

    public Node greedy_recursion(Node start){
        if(start.flag()==true) return start;
        else if(start.unexamined(start.get_neighbors()).size()==0){
            start.set_examined(true);
        } else {
            ArrayList<Node> nei = start.unexamined(start.get_neighbors());
            int least = start.get_neighbors().get(0).get_distance();
            Node closest = start.get_neighbors().get(0);
            for(int i=0;i<nei.size();i++){
                if(nei.get(i).get_distance()<least){
                    least = nei.get(i).get_distance();
                    closest = nei.get(i);
                }
            }
            start.set_examined(true);
            greedy_recursion(closest);
        }
        return null;
    }


    /*Combines g(n), cost to reach the node, and h(n), the cost to get from the node to the goal
     * h(n) is an admissible heuristic. i.e. it NEVER overestimates the true cost of a solution along the current path through n
     * For example, shortest path would be straight path to goal point, therefore it cannot be an overestimate
     * Second condition for h(n): it must be consistent (for every node n and every successor n' of n generated by action a, the estimated cost
     * of reaching the goal from n is no greater than the step cost of getting to n' plus the estimated cost of reaching the goal from n'
     * - Tree search is optimal if h(n) is admissible , while graph search is optimal if h(n) is consistent*/
    public Node a_star(){
        return null;
    }
}