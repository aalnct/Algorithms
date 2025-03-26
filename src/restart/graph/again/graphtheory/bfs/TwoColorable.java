package restart.graph.again.graphtheory.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TwoColorable {

    public static void main(String[] args) {
        int [] [] edges =  {
                {1,2}, {0,2},{0,1}
        };
        System.out.println(twoColorable(edges));
    }

    static boolean twoColorable (int [][] edges) {
        int [] colors = new int[edges.length]; // 0 uncolored, 1 first color, -1 second color

        for (int start = 0; start < edges.length; start++) {
            if (colors[start]!=0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            colors[start] = 1; // assign the first color

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int nei : edges[current]) {
                    if (colors[nei] == 0) {
                        colors[nei] = -colors[current];
                        queue.offer(nei);
                    } else if (colors[nei] == colors[current]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
