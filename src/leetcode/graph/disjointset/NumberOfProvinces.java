package leetcode.graph.disjointset;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * previously solved this problem using BFS approach (adding it to queue and then checking)
 * this time using the disjoint approach ...
 */
public class NumberOfProvinces {

    static int[] parent;
    static int[] rank; // to rank the nodes/cities

    public static void main(String[] args) {
        int[][] connected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        // System.out.println(findNumberOFProvinces(connected));
        System.out.println(numberOfProvince(connected));
    }

    public NumberOfProvinces(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i=0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0; // initially it will be zero since we do not know if it is connected ...
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x , int y) {
        int rootX = find(x);
        int rootY = find(y);

        // here we assign root based on rank ...
        if (rootX != rootY) {
            if (parent[rootX] > parent[rootY]) {
                rank[rootY] = rootX;
            } else if (parent[rootY] > parent[rootX]) {
                rank[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    private static int findNumberOFProvinces(int [][] connected) {
        int length = connected.length;
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces(length);

        for (int i=0; i < length; i++) {
            for (int j=i+1; j< length; j++) {
                if (connected[i][j] == 1) {
                    numberOfProvinces.union(i,j);
                }
            }
        }

        Set<Integer> provinces = new HashSet<>();

        for (int i=0; i < length; i++) {
            provinces.add(find(i));
        }
        return provinces.size();
    }

    private static int numberOfProvince(int[][] isConnected) {
        int length = isConnected.length;
        int provinces = 0;
        int[] visited = new int[length];

        for (int i=0; i < length; i++) {
            if (visited[i] == 0) {
                provinces++;
                breadthFirstSearch(isConnected,visited,i);
            }
        }

        return provinces;
    }

    private static void breadthFirstSearch(int[][] isConnected, int[] visited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = 1;

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
                if (isConnected[neighbour][currentCity] == 1
                && visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    queue.offer(neighbour);
                }
            }
        }
    }
}
