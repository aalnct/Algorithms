package leetcode.graph.bfs;

import java.util.*;

public class AllPathFromSourceTarget {

    public static void main(String[] args) {
        int [][] edges = {
                {1,2},
                {3},
                {3},
                {}
        };

        System.out.println(allPathsFromSourceToTarget(edges));
    }

    private static List<List<Integer>> allPathsFromSourceToTarget(int [][] edges) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // if current equals to target add that to list ...
        int target = edges.length-1;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(0)); // first will be index 0 which will have its own paths to other nodes ...


        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();

            int current = path.get(path.size()-1);

            if (current == target) {
                allPaths.add(path);
                continue;
            }
            for (int nextNode : edges[current]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nextNode);
                queue.offer(newPath);
            }
        }
        return allPaths;
    }
}
