package leetcode.graph.disjointset;

import java.util.*;

public class EveryoneBecomeFriends {

    static int[] parent;
    static int count; // this will count total people and will be set to n, once this decrements and reaches 1,
                     //  everyone becomes friends , return the timestamp

    public static void main(String[] args) {
        int [][] logs = {
                {0,2,0},
                {1,0,1},
                {3,0,3},
                {4,1,2},
                {7,3,1}
        };
        int n = 4;

        System.out.println(earliestAcqTime(logs,n));

        System.out.println(findMinTimeStamp(logs,n));
    }

    private static int earliestAcqTime(int[][] logs, int n) {

        parent = new int[n];

        for (int i=0; i < n; i++) {
            parent[i] = i;
        }
        count = n;

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        for (int [] log : logs) {
            int timeStamp = log[0];
            int person1 = log[1];
            int person2 = log[2];

            if (union(person1,person2) && getCount() == 1) {
                return timeStamp;
            }
        }
        return -1;
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false;
        }
        parent[parentX] = parentY;
        count--;
        return true;
    }

    private static int getCount() {
        return count;
    }


    /**
     * Using BFS approach
     *
     * using queue
     * adjacency list
     */

    private static int findMinTimeStamp(int [][] logs, int n) {
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        // creating an adjacency list to represent graph
        for (int i=0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int [] log : logs) {
            int timeStamp = log[0];
            int person1 = log[1];
            int person2 = log[2];

            adjacencyList.get(person1).add(person2);
            adjacencyList.get(person2).add(person1);

            if (isConnected(adjacencyList,n)) {
                return timeStamp;
            }
        }
        return -1;
    }

    private static boolean isConnected(List<List<Integer>> adjacencyList, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int connectedCount = 0;

        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true; // add the first one to array as true
                connectedCount++; // once its added increase the count

            while (!queue.isEmpty()) {
                int person = queue.poll();
                for (int friend : adjacencyList.get(person)) {
                    if (!visited[friend]) {
                        queue.offer(friend);
                        visited[friend] = true;
                        connectedCount++;
                    }
                }
            }
        }
        }
        return connectedCount == n;
    }
}
