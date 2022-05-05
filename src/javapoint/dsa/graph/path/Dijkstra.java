package javapoint.dsa.graph.path;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while(unsettledNodes.size() != 0) {
            // get the lowest distance node from unsettled list/set
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            // iterate for adjacent node
            for(Map.Entry<Node, Integer> adjacentPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacnetNode = adjacentPair.getKey();
                Integer edgeWeight = adjacentPair.getValue();

                // if not in settled List/Set then process
                if(!settledNodes.contains(adjacnetNode)) {
                    /**
                     * calculate the distance and add's the shortest path
                     */
                    calculateMinimumDistance(adjacnetNode, edgeWeight, currentNode);

                    // add adjacent node to unsettled priority queue
                    unsettledNodes.add(adjacnetNode);
                }
            }

            // add current node to settled queue one's processing is done
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        unsettledNodes.forEach(node -> System.out.print(node.getName() + "["+node.getDistance()+"]" +" " ));

        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for(Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();

            if(nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }

        System.out.println("" + lowestDistanceNode.getName());

        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();

        /**
         *  if source distance + edge weight is less then adjacent node,
         *  then update the adjacent node distance = (source distance + edge weight)
         *  Also update the shortest path
         */
        if(sourceDistance + edgeWeight < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
