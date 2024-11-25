package restart.graph.easy;

import java.util.*;

public class DijkstrasShortestReach {

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(Arrays.asList(1, 2, 24));
        edges.add(Arrays.asList(1, 4, 20));
        edges.add(Arrays.asList(3, 1, 3));
        edges.add(Arrays.asList(4, 3, 12));

        int s = 1; // this is starting node ....

        findShortestPath(n,edges,s)
                .forEach(System.out::println);
    }

    /**
     *
     * @param n number of nodes
     * @param edges :: edges given to travel
     * @param s : starting node
     * @return
     */
    static List<Integer> findShortestPath (int n, List<List<Integer>> edges, int s) {

        List<int[]> [] adjacencyList = new ArrayList[n+1];

        for (int i=1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2); // cost associated

            adjacencyList[u].add(new int[] {v,w});
            adjacencyList[v].add(new int[]{u,w});
        }

        int [] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[s] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        pq.add(new int[] {s,0});

        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) {
                continue;
            }

            for (int [] neighbour : adjacencyList[node]) {
                int nextNode = neighbour[0];
                int edgeWeight = neighbour[1];
                int newDist = dist + edgeWeight;

                if (newDist < distance[nextNode]) {
                    distance[nextNode] = newDist;
                    pq.offer(new int[] {nextNode, newDist});
                }
            }
        }


        List<Integer> result = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            if (i==s) {
                continue;
            }
            result.add(distance[i] == Integer.MAX_VALUE ? -1 : distance[i]);
        }

        return result;
    }

}
