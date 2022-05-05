package javapoint.dsa.graph.cycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int v) {
        this.V = v;

        adj = new ArrayList<>(V);

        for(int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    private void showGraph() {
        for (int i = 0; i < this.adj.size(); i++) {
            System.out.println("node " + i + ":" + this.adj.get(i));

        }
    }

    private boolean isCyclicUntil(int i, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and
        // add to recStack
        if(recStack[i]) {
            return true;
        }

        if(visited[i]) {
            return false;
        };

        visited[i] = true;
        recStack[i] = true;

        List<Integer> childrens = adj.get(i);

        for(Integer c: childrens ) {
            if(isCyclicUntil(c, visited, recStack)) {
                return true;
            }

        }

        recStack[i] = false;
        return false;
    }

    /**
     * Returns true if the graph contains a cycle
     * Else false
     *
     * @return boolean
     */
    private boolean isCyclic() {

        // mark all the vertice as not visited
        // and not a part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        for(int i =0; i < V; i++) {
            
            if(isCyclicUntil(i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);


//        graph.addEdge(1,3);
//        graph.addEdge(1,2);
//        graph.addEdge(2,4);
//        graph.addEdge(3,4);

        graph.showGraph();

        if(graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }


    }
}
