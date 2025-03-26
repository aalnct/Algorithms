package restart.graph.again.graphtheory;

import java.util.*;

public class DirectedAcyclicGraph {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1,2));
        graph.put(1, Arrays.asList(3));
        graph.put(2,Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(4, new ArrayList<>());

        List<List<Integer>> result = findPaths(graph,0,4);
        for (List<Integer> path : result) {
            System.out.println(path);
        }

    }

    static List<List<Integer>> findPaths (Map<Integer,List<Integer>> graph, int source, int destination) {
        List<List<Integer>> paths = new ArrayList<>(); // this will save all explored path
        List<Integer> current = new ArrayList<>(); // this will save current explore path
        current.add(source); // starting point
        dfs(graph,source,destination,current,paths);

        return paths;
    }

    static void dfs (Map<Integer,List<Integer>> graph, int source, int destination, List<Integer> current, List<List<Integer>> paths) {

        if (source == destination) {
            paths.add(new ArrayList<>(current));
            return;
        }

        // if there are no outgoing edges return
        if (!graph.containsKey(source) || graph.get(source) == null) {
            return;
        }

        // explore neighbour
        for (int neighbour : graph.get(source)) {
            current.add(neighbour);
            dfs(graph,neighbour,destination,current,paths);

            current.remove(current.size()-1); // backtracking
        }
    }
}
