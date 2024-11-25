package restart.dijkstra.hard;

import java.util.*;

/**
 * Find the shortest distance from source to destination in an undirected graph
 */
public class ShortestDistance {


    public static void main(String[] args) {
        int n1 = 21;
        int[][] edges1 = {
                {19, 0, 10},
                {5, 20, 3},
                {8, 18, 5},
                {6, 5, 17},
                {12, 9, 15},
                {19, 20, 10},
                {17, 15, 22},
                {6, 4, 14},
                {10, 11, 20},
                {1, 18, 6}
        };
        System.out.println(Arrays.toString(findAnswer(edges1, n1)));
    }
    private static boolean [] findAnswer (int [][] edges, int n) {
        // let's first create adjacency matrix
        // that will connect source to destination
        // both ways
        List<List<int[]>> graph = new ArrayList<>();
        // till number of edges

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] edge : edges) {
            int u = edge[0]; // source
            int v = edge[1]; // destination
            int w = edge[2]; // weight

            graph.get(u).add(new int[]{v,w}); // first from 0 to n-1
            graph.get(v).add(new int[] {u,w}); // then from n-1 to 0
        }

        // below helper function will help in calculate the minimum distance
        // and what ever is same in both , will be marked as true
        int [] distanceFromSource = dijkstras(n, graph, 0);
        int [] distanceToDestination = dijkstras(n,graph,n-1);

        int shortestPath = distanceFromSource[n-1];
        boolean [] answer = new boolean[edges.length];

        // checking each edge from source to destination
        for (int i=0; i < edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2]; // since it is (u,v,w)

            // once you have above, check if edge is part of shortest path calculated above
            if (distanceFromSource[u] + w + distanceToDestination[v] == shortestPath
            || distanceFromSource[v] + w + distanceToDestination[u] == shortestPath) {
                answer[i] = true;
            }
        }

        return answer;
    }

    private static int[] dijkstras (int n, List<List<int[]>> graph, int startPoint) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int [] {startPoint,0}); // starting point and distance to that starting point
        int [] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE); // initially fill the entire array with infinite value
        dist[startPoint] = 0;

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int u = current[0];
            int currentDistance = current[1];


            if (currentDistance > dist[u]) {
                continue; // if current distance is more than what is already found, then skip it ...
            }

            for (int [] neighbour : graph.get(u)) { // take the neighbours of current node
                int v = neighbour[0];
                int weight = neighbour[1];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    queue.offer(new int [] {v,dist[v]});
                }
            }
        }
        return dist;
    }
}
