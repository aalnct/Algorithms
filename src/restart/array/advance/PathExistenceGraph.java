package restart.array.advance;

import java.util.*;

public class PathExistenceGraph {

    public static void main(String[] args) {
        int n = 4;
        int [] nums = {2,5,6,8};
        int maxDiff = 2;
        int [][] queries = {
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        };

        System.out.println(Arrays.toString(pathExistenceGraph(n,nums,maxDiff,queries)));
    }

    static boolean [] pathExistenceGraph (int n, int [] nums, int maxDiff, int [][] queries) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i < n; i++) {
            for (int j = i+1; j < n && nums[j] - nums[i] <= maxDiff; j++) {
                // above is optimized solution instead of running O(n^2)
                graph.get(i).add(j);
                graph.get(j).add(i); // since it is undirected graph
            }
        }

        boolean [] result = new boolean[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int source = queries[q][0];
            int target = queries[q][1];

            if (source == target) {
                result[q] = true;
                continue;
            }

            boolean [] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : graph.get(current)) {
                    if (neighbor == target) {
                        result[q] = true;
                        break;
                    }
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }

                if (result[q]) {
                    break; //found the path, can break the loop
                }
            }
        }
        return result;
    }
}
