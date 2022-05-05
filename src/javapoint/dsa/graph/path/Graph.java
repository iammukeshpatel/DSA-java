package javapoint.dsa.graph.path;

import java.util.*;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);


        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
//        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeB);

        for(Node n: graph.getNodes()) {
            System.out.println(nodeB.getName()+ " -> "+ n.getName() + " "+ n.getDistance());
        }


        List<Node> n = graph.getNodes().stream().filter(node -> node.getName() == nodeE.getName()).toList();

        System.out.println(n.get(0).getShortestPath().size());
        Iterator iterator = n.get(0).getShortestPath().listIterator();

        while (iterator.hasNext()) {
            Node currentNode = (Node) iterator.next();
            System.out.print(currentNode.getName() + " ");
        }
    }

}
