package restart.famous.algorithm;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge (int src, int desc, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}
public class KruskalsAlgorithm {

    int vertices;
    List<Edge> edges;

    public KruskalsAlgorithm (int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdges (int src, int dest, int weight) {
        this.edges.add(new Edge(src,dest,weight));
    }

    public static void main(String[] args) {
        int v = 4;
        KruskalsAlgorithm kruskalsAlgorithm = new KruskalsAlgorithm(v);

        kruskalsAlgorithm.addEdges(0,1,10);
        kruskalsAlgorithm.addEdges(0,2,6);
        kruskalsAlgorithm.addEdges(0,3,5);
        kruskalsAlgorithm.addEdges(1,3,15);
        kruskalsAlgorithm.addEdges(2,3,4);

        List<Edge> mst = kruskalsAlgorithm.minimumSpanningTree();
        kruskalsAlgorithm.print(mst);
    }

    // create an adjacncy list
    // that will help us create MST
    // also keep checking if adding any edge will create a cycle or not

    private List<Edge> minimumSpanningTree () {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        int edgeCount = 0;

        for (Edge edge : edges) {
            if (edgeCount >= vertices - 1) {
                break;
            }


            if (!hasCycle(adjList, edge.src, edge.dest)) {
                result.add(edge);

                adjList.get(edge.src).add(edge.dest);
                adjList.get(edge.dest).add(edge.src);

                edgeCount++;
            }
        }
        return result;
    }

    private boolean hasCycle (List<List<Integer>> adjList, int src, int dest) {
        boolean [] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.offer(src);



        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == dest) {
                return true;
            }

            for (int neighbour : adjList.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }

    private void print (List<Edge> mst) {
        System.out.println("Edges in the mst :");
        int totalWeight = 0;

        for (Edge edge : mst) {
            System.out.println(edge.src + " ---- " + edge.dest + " ==== " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST :" + totalWeight);
    }
}
