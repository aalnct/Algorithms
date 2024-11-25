package OAGoogle.graphtheory._50daychallenge;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2));
        graph.put(1, Arrays.asList(0,2,3));
        graph.put(2,Arrays.asList(0,1,4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(2));

        int start = 0;
        int end = 4;

        List<Integer> shortestPath = findShortestPath(graph,start,end);
        System.out.println(Arrays.toString(shortestPath.toArray()));
    }

    private static List<Integer> findShortestPath(Map<Integer, List<Integer>> graph, int start, int end) {
        Map<Integer,Integer> parentMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current ==  end) {
                // call the construct path method here (impl for that under progress)
                return reConstructPath(parentMap,end);
            }

            // time to explore neighbors of the current node ...
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor,current);
                }
            }
        }

        return new ArrayList<>(); // no path available ...
    }

    private static List<Integer> reConstructPath (Map<Integer,Integer> parentMap, int end) {
        List<Integer> path = new ArrayList<>();
        while (parentMap.containsKey(end)) {
            path.add(end);
            end = parentMap.get(end);
        }
        Collections.reverse(path);
        return path;
    }
}
