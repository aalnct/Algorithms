package leetcode.graph.kahn.algorithm;

import java.util.*;

public class MinimumHeightTree {

    public static void main(String[] args) {
        int n=4;
        int [][] edges = {
                {1,0},
                {1,2},
                {1,3}
        };

        minimumHeightTree(n,edges).forEach(System.out::println);
    }

    private static List<Integer> minimumHeightTree(int n, int [][] edges) {
        List<Set<Integer>> minHeightTree = new ArrayList<>();

        int [] inDegrees = new int[n];

        for (int i=0; i < n; i++) {
            minHeightTree.add(new HashSet<>());
        }

        for (int [] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            // since it is undirected graph we explore both options

            minHeightTree.get(source).add(destination);
            minHeightTree.get(destination).add(source);

            inDegrees[source]++;
            inDegrees[destination]++;
        }

        // to maintain leaves
        Queue<Integer> leaves = new LinkedList<>();
        for (int i=0; i < n; i++) {
            if(inDegrees[i] == 1) {
                leaves.offer(i);
            }
        }

        while (n > 2) {
            int size = leaves.size();
            n -=size;

            for(int i=0; i < size;i++) {
                int leaf = leaves.poll();
                for (int neighbor : minHeightTree.get(leaf)) {
                    inDegrees[neighbor]--;
                    if (inDegrees[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>(leaves);
        return result;
    }
}
