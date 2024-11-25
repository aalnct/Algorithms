package restart.graph.medium;

import java.util.*;

public class RustMurdered {

    public static void main(String[] args) {
        int nodes = 4;
        int [][] roads = {
                {1, 2}, {2, 3}
        };

        int [] output = rustMurderer(nodes,roads);
        System.out.println(Arrays.toString(output));
    }

    static int [] rustMurderer (int nodes, int [][] roads) {
        // solve using BFS
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i=0; i < nodes; i++) {
            graph.add(new HashSet<>());
        }

        for (int [] road : roads) {
            int u = road[0] - 1; // converting 1 based index to 0 based index
            int v = road[1] - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        int [] distance = new int[nodes];
        Arrays.fill(distance,-1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentDistance = distance[currentNode];

            for (int neighbour = 0; neighbour < nodes; neighbour++) {
                if (neighbour != currentNode && !graph.get(currentNode).contains(neighbour)
                        && distance[neighbour] == -1) {
                    //if (distance[neighbour] == -1) {
                        // Mark distance and add to the queue
                        distance[neighbour] = currentDistance + 1;
                        queue.offer(neighbour);
                    // }
                }
            }
        }

        int [] result = new int[nodes - 1];
        int index = 0;
        for (int i=1; i < nodes; i++) {
            result[index++] = distance[i];
        }

        return result;
    }
}
