package dsa.graph.undirected;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
    int noOfVertices;

    // Array of lists for
    // Adjacency List Representation
    LinkedList<Integer> adj[];

    DFSGraph(int verticesCount) {
        noOfVertices = verticesCount;

        adj = new LinkedList[noOfVertices];
        for(int i = 0; i <noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    void  DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        System.out.println(v +" - "+ adj[v]);
        while(i.hasNext()) {
            int node = i.next();

            if(!visited[node]) {
                DFSUtil(node, visited);
            }
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[noOfVertices];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
//        DFSGraph g = new DFSGraph(4);

//        g.addEdge(0,1);
//        g.addEdge(0,2);
//        g.addEdge(1,2);
//        g.addEdge(2,0);
//        g.addEdge(2,3);
//        g.addEdge(3,3);


        DFSGraph g = new DFSGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(0);
    }
}
