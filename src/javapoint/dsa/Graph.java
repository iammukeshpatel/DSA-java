package javapoint.dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    private void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);

        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public void countVertices() {
        System.out.println("Total number of vertices" + map.keySet().size());
    }

    public void countEdges(boolean bidirection) {
        int count = 0;

        for (T vertive : map.keySet()) {
            count += map.get(vertive).size();
        }

        if (bidirection == true) {
            count = count / 2;
        }

        System.out.println("Total number of edges: " + count);
    }

    public void containsVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    //checks a graph has edge or not
    //where s and d are the two parameters that represent source(vertex) and destination (vertex)
    public void containsEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("There is no edge between " + s + " and " + d + ".");
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // foreach loop that iterates over the keys
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            // foreach loop for getting the vertices
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}

