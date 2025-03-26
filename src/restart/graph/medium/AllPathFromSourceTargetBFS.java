package restart.graph.medium;

import java.util.*;

public class AllPathFromSourceTargetBFS {


    public static void main(String[] args) {
        int[][] graphs = {
                {1, 2},
                {3},
                {3},
                {}
        };

        List<List<Integer>> result = allPaths(graphs);
        for (List<Integer> integers : result) {
            integers.forEach(System.out::print);
        }
    }

    static List<List<Integer>> allPaths (int [][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        int target = graph.length-1; // destination node
        queue.offer(Arrays.asList(0));

        while (!queue.isEmpty()) {
            List<Integer> currPath = queue.poll();
            int current = currPath.get(currPath.size()-1);

            if (current == target) {
                result.add(currPath);
                continue;
            }

            for (int nei : graph[current]) {
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(nei);
                queue.offer(newPath);
            }
        }
        return result;
    }
}
