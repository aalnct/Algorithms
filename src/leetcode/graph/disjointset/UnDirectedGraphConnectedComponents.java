package leetcode.graph.disjointset;

import java.util.HashSet;
import java.util.Set;

public class UnDirectedGraphConnectedComponents {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {3,4},
        };
        int n = 5;
        System.out.println(countComponent(n, edges));
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false; // since they are part of the same component, cannot increase the unique count
        }

        if (rank[parentY] > rank[parentX]) {
            parent[parentX] = parentY;
        } else if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
        return true;
    }

    private static int countComponent(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i=0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int [] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            union(x,y);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }
}