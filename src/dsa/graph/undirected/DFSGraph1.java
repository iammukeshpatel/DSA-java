package dsa.graph.undirected;

import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph1 {
    int noOfNode;
    LinkedList<Integer>[] adj;

    DFSGraph1(int nodeCount) {
        this.noOfNode = nodeCount;
        adj = new LinkedList[nodeCount];

        for (int i= 0; i< nodeCount; i++ ) {
            adj[i] =new LinkedList<>();
        }
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);                              //adding an edge to the adjacency list (edges are bidirectional in this example)
    }

    void DFS( int n) {

        System.out.println("DFS Started");
        boolean visited[] = new boolean[noOfNode];

        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        //push root node to the stack
        int a = 0;
        System.out.println("Stack "+stack);
        while (!stack.empty()) {
            n = stack.peek();
            System.out.println("While loop stack " + stack);

            stack.pop();


            if(visited[n] == false) {
                System.out.print(n + ", ");
                visited[n] = true;
            }


            System.out.println("fore" + adj[n]);
            for (int i =0; i < adj[n].size(); i ++) {
                a = adj[n].get(i);
                if(!visited[a]) {
                    System.out.println("stack addeed with" + a);
                    stack.push(a);
                }
            }
        }
    }

    public static void main(String args[]) {
        DFSGraph1 g = new DFSGraph1(6);

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

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }
}
