package restart.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFord {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int vertices = 5;

        // create a list of edges
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, -1)); // Edge from A to B with weight -1
        edges.add(new Edge(0, 2, 4));  // Edge from A to C with weight 4
        edges.add(new Edge(1, 2, 3));  // Edge from B to C with weight 3
        edges.add(new Edge(1, 3, 2));  // Edge from B to D with weight 2
        edges.add(new Edge(1, 4, 2));  // Edge from B to E with weight 2
        edges.add(new Edge(3, 2, 5));  // Edge from D to C with weight 5
        edges.add(new Edge(3, 1, 1));  // Edge from D to B with weight 1
        edges.add(new Edge(4, 3, -3)); // Edge from E to D with weight -3

        bellmanFord(edges,vertices,0);
    }

    public static void bellmanFord(List<Edge> edges, int vertices, int source) {
        int [] distance = new int[vertices];
        Arrays.fill(distance, INF);
        distance[source] = 0;

        // Step 1 : Relax all edges v-1 times
        for (int i=0; i < vertices-1;i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != INF && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // step 2 : Check for negative weight cycle
        for (Edge edge : edges) {
            if (distance[edge.source] != INF && distance[edge.source] + edge.weight  < distance[edge.destination]) {
                System.out.println(" **** Graph contains a negative weight cycle **** ");
                return;
            }
        }

        printDistance(distance);
    }

    private static void printDistance (int [] distance) {
        System.out.println("Printing distance");

        for (int i=0; i < distance.length; i++) {
            System.out.println((char) (i + 'A') + " \t\t " + (distance[i] == INF ? "INF" : distance[i]));
        }
    }
}
