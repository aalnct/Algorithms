package leetcode.graph.random.questions;

import java.util.*;

/**
 * to find the shortest path of unweighted graph we will use BFS approach
 */
public class ShortestPathUnweighted {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 5;
        for (int i=0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
            graph.get(0).add(1);
            graph.get(0).add(2);
            graph.get(1).add(3);
            graph.get(2).add(4);
            graph.get(3).add(5);
            graph.get(4).add(5);

            int startNode = 0;
            int endNode = 5;

            List<Integer> shortestPath = shortestPathBFS(graph,startNode,endNode);

            if(!shortestPath.isEmpty()) {
                System.out.println(Arrays.toString(shortestPath.toArray()));
            } else {
                System.out.println("No Path Found from " + startNode + " to" + endNode);
            }
    }

    private static List<Integer> shortestPathBFS(List<List<Integer>> graph, int source, int destination) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[graph.size()];
        int [] parent = new int[graph.size()];

        Arrays.fill(parent,-1);

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.offer(neighbor);

                    if (neighbor == destination) {
                        // construct path to reach here
                        return reconstructPath(parent, source, destination);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Integer> reconstructPath(int [] parent, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        int current = destination;

        while(current != -1) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);

        return path;
    }
}
