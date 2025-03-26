package restart.graph.again.graphtheory.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBiPartition {

    public static void main(String[] args) {
        int [] [] dislikes = {
                {1,2}
                ,
                {1,3}
                ,
                {2,3}
        };
        System.out.println(isPossibleBiPartition(4,dislikes));
        System.out.println(isBiPartition(4, dislikes));
    }


    // without adjacency list
    static boolean isPossibleBiPartition (int n, int [][] dislikes) {

        // dislikes [][] ==
        // {1,2}, {1,3}, {24}

        int [] color = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1 ; i <= n; i++) {
            if (color[i] == 0) {
                queue.offer(i);
                color[i] = 1;

                while (!queue.isEmpty()) {
                    int current = queue.poll();

                    for (int [] dislike : dislikes) {
                        int a = dislike[0];
                        int b = dislike[1];

                        // we are examining is current person, and person b is not assign a group, then assign it opposite group
                        // of current person A
                        if (a == current && color[b] == 0) {
                            color[b] = -color[current];
                            queue.offer(b);
                        } else if (a == current && color[b] == color[current]) {
                            return false;
                        } else if (b == current && color[a] == 0) {
                            color[a] = -color[current];
                            queue.offer(a);
                        } else if (b == current && color[a] == color[current]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // this approach is using adjacency list to improve performance
    static boolean isBiPartition (int n, int [][] dislikes) {
        int [] colors = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=1; i <= n; i++) {
            if (colors[i] == 0 && !bfs(i, graph, colors)) {
                return false;
            }
        }
        return true;
    }

    static boolean bfs (int start, List<List<Integer>> graph, int [] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int nei : graph.get(current)) {
                if (colors[nei] == 0) {
                    colors[nei] = -colors[current];
                    queue.offer(nei);
                } else if (colors[nei] == colors[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}
