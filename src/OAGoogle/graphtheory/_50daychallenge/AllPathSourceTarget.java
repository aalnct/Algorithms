package OAGoogle.graphtheory._50daychallenge;

import java.util.*;

public class AllPathSourceTarget {

    public static void main(String[] args) {
        int [][] graph = {
                {1,2}, // neighbour of node 0
                {3}, // neighbour of node 1
                {3}, // neighbour of node 2
                {} // neighbour of node 3
        };

        List<List<Integer>> output = allPathSourceTarget(graph);
        for (List<Integer> result : output) {
            for (Integer re : result) {
                System.out.println(re);
            }
        }
    }

    static List<List<Integer>> allPathSourceTarget (int [][] graph) {

        // adjancency list
        List<List<Integer>> paths = new ArrayList<>();
        int source = 0;
        int target = graph.length-1;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(source)); // starting from node 0

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int currentNode = currentPath.get(currentPath.size()-1);

            if (currentNode == target) {
                paths.add(new ArrayList<>(currentPath));
                continue;
            }

            for (int neighbour : graph[currentNode]) {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(neighbour);
                queue.offer(newPath);
            }

        }
        return paths;
    }
}
