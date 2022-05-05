package javapoint.dsa.graph.search;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int noOfVertices;

    private LinkedList<Integer>[] adjList;
    public boolean[] visited ;

    Graph(int verticesCount) {
        noOfVertices = verticesCount;

        adjList = new LinkedList[verticesCount];
        visited = new boolean[verticesCount];

        for (int i =0; i < verticesCount; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w ) {
        adjList[v].add(w);
    }

    void traverseDFS(int v) {
        visited[v] = true;

        System.out.print(v + " ");

//        System.out.println(adjList[v]);
        Iterator<Integer> iterator = adjList[v].listIterator();

        while (iterator.hasNext()) {
            int n = iterator.next();

            if(!visited[n]) {
                traverseDFS(n);
            }
        }
    }

//    void DFS(int v) {
//        boolean visited[] = new boolean[noOfVertices];
//
//        traverse(v, visited);
//    }

    void traverseBFS(int rootNode) {


        // creates an array of boolean type for visited node
        // initially all nodes are unvisited
        boolean visited[] = new boolean[noOfVertices];


        // creating another list for storing the visited node
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[rootNode] = true;

        queue.add(rootNode);

        while (queue.size() != 0) {

            // deque an entry from queue and process it
            // the poll() method retrieves and removes the head (first element) of this list
            rootNode = queue.poll();

            System.out.print(rootNode + " ");

            // detrmines the negihboring nodes of the current node
            // iterates over the list
            Iterator<Integer> iterator = adjList[rootNode].listIterator();

            while (iterator.hasNext()) {
                int n = iterator.next();

                if(!visited[n]) {
                    visited[n] = true;

                    queue.add(n);
                }
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // foreach loop that iterates over the keys
//        for (int i = 0; i < adjList.length; i++) {
        for (int i = 0; i < adjList.length; i++) {
//            LinkedList w = adjList[i];
            builder.append(i + ": ");
            // foreach loop for getting the vertices
            for (int w : adjList[i]) {
                builder.append(w + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
