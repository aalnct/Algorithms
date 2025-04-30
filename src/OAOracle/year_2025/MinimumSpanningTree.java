package OAOracle.year_2025;


import java.util.*;

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    public Edge (int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
}
public class MinimumSpanningTree {

    public static void main(String[] args) {
        int vertices = 5;
        List<Edge> edges = new ArrayList<>();
        // Adding edges: (src, dest, weight)
        edges.add(new Edge(0, 1, 4));  // A-B
        edges.add(new Edge(0, 2, 2));  // A-C
        edges.add(new Edge(1, 2, 1));  // B-C
        edges.add(new Edge(1, 3, 5));  // B-D
        edges.add(new Edge(2, 3, 8));  // C-D
        edges.add(new Edge(2, 4, 10)); // C-E
        edges.add(new Edge(3, 4, 2));  // D-E

        System.out.println(" Finding Minimum Spanning tree ");
        List<Edge> mst = findMST(edges,vertices);

        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(" Edge ::" + edge);
            totalWeight += edge.weight;
        }

        System.out.println(" Total Weight :: " + totalWeight);
    }
    public static List<Edge> findMST (List<Edge> edges, int vertices) {
        Collections.sort(edges);
        System.out.println(" Sorted Edges already ");

        for (Edge edge : edges) {
            System.out.println(edge);
        }

        System.out.println();

        List<Edge> mst = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            System.out.println(" Considering edges : " + edge);

            boolean createCycles = false;

            if (!mst.isEmpty()) {
                createCycles = hasCycle (graph,edge.src,edge.dest);
            }

            if (createCycles) {
                System.out.println(" Cycle Created, so have to skip this edge ");
            }
             else {
                 mst.add(edge);
                System.out.println( " Added to MST" );

                graph.get(edge.src).add(edge.dest);
                graph.get(edge.dest).add(edge.src);

                System.out.println(" Current MST :: " + mst);
            }

             if (mst.size() == vertices-1) {
                 System.out.println(" MST complete ");
                 break;
             }
            System.out.println();
        }
        return mst;
    }

    static boolean hasCycle (List<List<Integer>> graph, int src, int dest) {
        return hasPath (graph,src,dest, new boolean[graph.size()]) ;
    }

    static boolean hasPath (List<List<Integer>> graph, int src, int dest, boolean [] visited) {
        System.out.println("Checking for existing path from " + src + " to destination " + dest);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(" Current vertex " + current);

            if (current == dest) {
                System.out.println(" Cycle created, so cannot add this vertex ");
                return true;
            }

            for (int nei : graph.get(current)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                }
            }
        }
        System.out.println( " No path found , safe to add " );

        return false;
    }
}
