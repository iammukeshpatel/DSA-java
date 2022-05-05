package dsa.graph.undirected;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
    private int noOfVertices;
    LinkedList<Integer> adj[];

    BFSGraph(int v) {
        noOfVertices = v;
        adj = new LinkedList[v];

        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);

//        System.out.println(adj[v]);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[noOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        System.out.println(s);
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+", ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            System.out.print(adj[s]);

//            System.out.print("Added To queue");
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
//                    System.out.print(" " + n);
                    queue.add(n);
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(0);
    }
}
