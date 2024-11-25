package restart.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
        // class to represent a node in the PQ

        static class Node implements Comparable<Node> {

            int vertex;
            int distance;

            public Node (int vertex, int distance) {
                this.vertex = vertex;
                this.distance = distance;
            }

            @Override
            public int compareTo(Node other) {
                return Integer.compare(this.distance, other.distance);
            }
        }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> graph = new ArrayList<>(vertices);

        for (int i=0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (source, target, weight)
        // just creating the entire graph
        graph.get(0).add(new Edge(1, 2)); // A -> B (2)
        graph.get(0).add(new Edge(2, 1)); // A -> C (1)
        graph.get(1).add(new Edge(3, 3)); // B -> D (3)
        graph.get(1).add(new Edge(2, 1)); // B -> C (1)
        graph.get(2).add(new Edge(4, 1)); // C -> E (1)
        graph.get(4).add(new Edge(3, 1)); // E -> D (1)

        int [] distance = dijkstra(graph,vertices,0); // graph, vetices, source

        // print shortes distance from source to destination
        for (int i=0; i < distance.length; i++) {
            System.out.println("Distance from A to " + (char) (i + 'A') + " : " + distance[i]);
        }
    }

    public static int [] dijkstra(List<List<Edge>> graph, int vertices, int source) {
        int [] distance = new int[vertices];
        boolean [] visited = new boolean[vertices];
        PriorityQueue<Node> priorityQueue = new PriorityQueue();

        // Initialize distance and priority queue
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        priorityQueue.add(new Node(source,0));


        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;

            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;

            // now explore neighbour
            for (Edge edge : graph.get(currentVertex)) {
                int neighbour = edge.target;
                int newDistance = distance[currentVertex] + edge.weight;

                if (newDistance < distance[neighbour]) {
                    distance[neighbour] = newDistance;
                    priorityQueue.add(new Node(neighbour,newDistance));
                }
            }
        }

        return distance;
    }
}