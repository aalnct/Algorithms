package restart.graph.medium;

import java.util.*;

public class ShortestPathFromSourceTargetBFS {

    public static void main(String[] args) {
        int[][] graphs = {
                {1, 2},
                {3},
                {3},
                {}
        };
        shortestPath(graphs).forEach(System.out::println);
    }

    static List<Integer> shortestPath (int [][] graph) {
        Queue<List<Integer>> queue = new LinkedList<>();

        int target = graph.length-1;

        queue.offer(Collections.singletonList(0));

        while (!queue.isEmpty()) {
            List<Integer> currPath = queue.poll();
            int current = currPath.get(currPath.size()-1);

            if (current == target) {
                return currPath;
            }

            for (int nei : graph[current]) {
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(nei);
                queue.offer(newPath);
            }
        }
        return new ArrayList<>();
    }
}
