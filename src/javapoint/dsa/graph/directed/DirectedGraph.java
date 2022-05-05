package javapoint.dsa.graph.directed;

import java.util.Arrays;
import java.util.List;

public class DirectedGraph {
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                    new Edge(0, 1),
                    new Edge(1, 2),
                    new Edge(2, 4),
                    new Edge(4, 1),
                    new Edge(3, 2),
                    new Edge(2, 5),
                    new Edge(3, 4),
                    new Edge(5, 4),
                    new Edge(1, 1)
                );

        Graph graph = new Graph(edges);

        //prints the adjacency list that represents graph
        Graph.showGraph(graph);

    }
}
