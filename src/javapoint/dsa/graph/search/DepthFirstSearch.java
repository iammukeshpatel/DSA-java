package javapoint.dsa.graph.search;

public class DepthFirstSearch {

    public static void main(String args[]) {
        Graph g = new Graph(10);

        //add edges to the graph
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 7);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);

        System.out.println("Graph: "+ g.toString());

        // print sequencnce in which BFS traversal done
        System.out.println("Depth-first traversal of graph is: ");

        // traversal starts from the node 3 (as root node)
        g.traverseDFS(1);
    }
}
