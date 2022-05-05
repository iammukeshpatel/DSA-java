package javapoint.dsa;

public class GraphImplementation {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        //adding edges to the graph
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(3, 0, true);
        graph.addEdge(2, 0, true);


        // prints the adjacency matrix that represents the graph
        System.out.println("Adjacency List for the graph:\n"+ graph.toString());

        // counts the number of vertices in the graph
        graph.countVertices();

        // counts the number of edges in the graph
        graph.countEdges(true);

        // checks whether an edge is present or not between the two specified vertices
        graph.containsEdge(3, 4);
        graph.containsEdge(2, 4);

        // checks whether vertex is present or not
        graph.containsVertex(3);
        graph.containsVertex(5);
    }
}

