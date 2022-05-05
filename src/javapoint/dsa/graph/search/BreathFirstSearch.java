package javapoint.dsa.graph.search;

public class BreathFirstSearch {
    public static void main(String[] args) {

        //creates a graph having 10 vertices
        Graph graph = new Graph(10);

        // add edges to the graph
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 1);
        graph.addEdge(6, 2);
        graph.addEdge(5, 6);
        graph.addEdge(1, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 1);
        graph.addEdge(7, 3);
        graph.addEdge(3, 7);
        graph.addEdge(7, 5);

        System.out.println("Graph: "+ graph.toString());


        // print sequence in which BFS traversal execute
        System.out.println("Breadth-first traversal sequence is: ");

        // root node
        graph.traverseBFS(2);
    }
}
