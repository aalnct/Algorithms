package leetcode.graph.bfs;

import java.util.*;

public class MinVerticesToReachAllNodes {

    public static void main(String[] args) {
        int [][] edges = {
                {0,1},
                {0,2},
                {2,5},
                {3,4},
                {4,2}
        };
        int n = 6;
        System.out.println(Arrays.toString(minimumVerticesToReachAllNodes(edges,n).toArray()));
    }

    private static List<List<Integer>> minimumVerticesToReachAllNodes (int [][] edges, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int [] edge : edges) {
            adjList.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
        }

        for(int i=0; i < n; i++) {
            if (!visited.contains(i)) {
                List<Integer> currentPath = new ArrayList<>();
                breadthFirstSearch(adjList,i,visited, currentPath);
                result.add(currentPath);
            }
        }
        return result;
    }

    private static void breadthFirstSearch(Map<Integer,List<Integer>> graph, int start, Set<Integer> visited, List<Integer> currentPath) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            currentPath.add(current);
            if(graph.containsKey(current)) {
                for(int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
}
