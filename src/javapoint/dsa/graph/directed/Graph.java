package javapoint.dsa.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adjList = new ArrayList<>();

    public Graph(List<Edge> edges) {
        int n = 0;

        // foreach loop that iterates over the edge
        for (Edge e : edges) {
            // determines the maximum numbered vertex
            n = Integer.max(n, Integer.max(e.s, e.d));
        }

        // reserve the space for the adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // adds the edges to the undirected graph
        for (Edge current : edges) {
            // allocate new node in adjacency list from source to destination
            adjList.get(current.s).add(current.d);
        }
    }

    public static void showGraph(Graph graph) {
        int s = 0;

        // determine the size of adjacency List
        int n = graph.adjList.size();

        System.out.println("Adjacency List for the graph is:");
        while (s < n) {

            for (int d: graph.adjList.get(s)) {

                // prints the edge between the two vertices
                System.out.print("(" + s + " -- > " + d + ")\t");
            }

            System.out.println();
            // increments the source by 1
            s++;
        }
    }
}
