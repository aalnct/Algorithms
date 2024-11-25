package restart.graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class JourneyToMoon {

    public static void main(String[] args) {
        int n = 100000;
        List<List<Integer>> astronaut = new ArrayList<>();

        // [0,1,4] and [2,3]
        astronaut.add(Arrays.asList(1,2));
        astronaut.add(Arrays.asList(3,4));
        // astronaut.add(Arrays.asList(0,4));

        System.out.println(journeyToMoon(n,astronaut));
    }

    static int journeyToMoon (int n, List<List<Integer>> astronaut) {

        // either use BFS approach i.e. queue
        // or use DFS approach i.e. stack

        // DFS
        List<Integer> [] graph = new ArrayList[n];
        boolean [] visited = new boolean[n];
        for (int i=0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> pair : astronaut) {
            int u = pair.get(0);
            int v = pair.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        List<Integer> componentSize = new ArrayList<>();
        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(graph,visited,i);
                componentSize.add(size);
            }
        }

        long totalPairs = 0;
        int sum = 0;

        for (int size :componentSize) {
            sum +=size;
        }

        // for each component, calculate each pairs it can form

        for (int size : componentSize) {
            sum -=size;
            totalPairs += (long) size * sum;
        }

        return (int)totalPairs;
    }

    static int dfs (List<Integer> [] graph, boolean [] visited, int currentNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);
        visited[currentNode] = true;

        int size = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            size++;
            for (int neighbour : graph[current]) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return size;
    }
}
