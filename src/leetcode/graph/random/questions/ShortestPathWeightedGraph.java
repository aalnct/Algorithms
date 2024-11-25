package leetcode.graph.random.questions;

import java.util.*;

/**
 * Solving using Dijkstra's algorithm since it is a weighted graph
 */
public class ShortestPathWeightedGraph {

    public static void main(String[] args) {
        List<List<Edges>> graph = new ArrayList<>();
        for (int i=0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edges(1,2));
        graph.get(0).add(new Edges(2,4));
        graph.get(1).add(new Edges(3,1));
        graph.get(2).add(new Edges(4,3));
        graph.get(3).add(new Edges(5, 5));
        graph.get(4).add(new Edges(5, 2));

        int start = 0;
        int destination = 5;

        List<Integer> list = shortestPathDijkstras(graph,start,destination);

        System.out.println(Arrays.toString(list.toArray()));

    }

    static class Edges {
        int destination;
        int weight;

        public Edges(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance =distance;
        }
    }

    private static List<Integer> shortestPathDijkstras(List<List<Edges>> graph,
                                                       int start, int destination) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        int [] distance = new int[graph.size()];
        int [] parent = new int[graph.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent,-1);

        distance[start] =0;
        priorityQueue.offer(new Node(start,0));

        while(!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Edges neighbor : graph.get(current.vertex)) {
                int newDistance = distance[current.vertex] + neighbor.weight;

                if(newDistance < distance[neighbor.destination]) {
                    distance[neighbor.destination] = newDistance;
                    parent[neighbor.destination] = current.vertex;
                    priorityQueue.offer(new Node(neighbor.destination,newDistance));

                    if (neighbor.destination == destination) {
                        return reconstructPath(parent,start,destination);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Integer> reconstructPath(int [] parent, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        int current = destination;

        while(current != -1) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);
        return path;
    }
}
