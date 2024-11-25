package restart.graph.easy;

import java.util.*;

public class BFSShortestDistance {

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(1,3));
        int s = 1;

        bfs(n,m,edges,s).forEach(System.out::println);
    }


    private static List<Integer> bfs (int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> [] graph = new ArrayList[n+1];

        for (int i=1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        int [] distance = new int[n+1];
        Arrays.fill(distance,-1);
        queue.offer(s);
        distance[s] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph[current]) {
                if (distance[neighbour] == -1) {
                    queue.offer(neighbour);
                    distance[neighbour] = distance[current] + 6;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=1;i<=n ;i++) {
            if (i != s) {
                result.add(distance[i]);
            }
        }
        return result;
    }

}
