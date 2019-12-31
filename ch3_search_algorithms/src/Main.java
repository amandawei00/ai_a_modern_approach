import java.util.ArrayList;

// to do:
// 1. graphical demonstration

public class Main {
    public static void main(String[] args){
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Link> links = new ArrayList<Link>();

        Node n0 = new Node(0,3,false);
        Node n1 = new Node(1,4,false);
        Node n2 = new Node(2,10,false);
        Node n3 = new Node(3,5,false);
        Node n4 = new Node(4,6,false);
        Node n5 = new Node(5,2,true);
        Node n6 = new Node(6,3,false);
        Node n7 = new Node(7,11,false);
        Node n8 = new Node(8,7,false);

        Link l01 = new Link(n0,n1,4);
        Link l07 = new Link(n0,n7,8);
        Link l17 = new Link(n1,n7,11);
        Link l12 = new Link(n1,n2,8);
        Link l28 = new Link(n2,n8,2);
        //Link l25 = new Link(n2,n5,4);
        Link l23 = new Link(n2,n3,7);
        Link l34 = new Link(n3,n4,9);
        //Link l35 = new Link(n3,n5,14);
        //Link l45 = new Link(n4,n5,10);
        Link l56 = new Link(n5,n6,2);
        Link l68 = new Link(n6,n8,6);
        Link l67 = new Link(n6,n7,1);
        Link l78 = new Link(n7,n8,7);

        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);
        nodes.add(n8);

        links.add(l01);
        links.add(l07);
        links.add(l17);
        links.add(l12);
        links.add(l28);
        //links.add(l25);
        links.add(l23);
        links.add(l34);
        //links.add(l35);
        //links.add(l45);
        links.add(l56);
        links.add(l68);
        links.add(l67);
        links.add(l78);

        //Runs through each link, adds each to the other's neighbors list and vice versa
        for(int i=0;i<links.size();i++){
            Node parent = links.get(i).get_parent();
            Node child = links.get(i).get_child();
            if(!parent.get_neighbors().contains(child)){
                parent.add_neighbors(child);
            }
            if(!child.get_neighbors().contains(parent)){
                child.add_neighbors(parent);
            }
        }


        /*for(int i=0;i<nodes.size();i++){
            nodes.get(i).print_neighbors();
        }*/

        Graph g = new Graph(nodes, links);
        //Setting up timer to measure performance of each search algorithm

        long init = System.nanoTime();
        //System.out.println(g.breadth_first().get_index());
        System.out.println(g.breadth_first());
        long end = System.nanoTime();
        long elapsed = end - init;
        System.out.println("This algorithm was completed in " + elapsed + " nanoseconds");

        //System.out.println(g.depth_first(nodes.get(0)).get_index());

    }
}

