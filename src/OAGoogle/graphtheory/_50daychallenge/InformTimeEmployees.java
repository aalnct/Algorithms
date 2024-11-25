package OAGoogle.graphtheory._50daychallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InformTimeEmployees {

    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};

        System.out.println(numOfEmployees(n,headID,manager,informTime));
    }

    private static int numOfEmployees(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i); // adding employee i as a subordinate to their manager
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {headID, 0}); // head employee and their corresponding inform time
        int maxInformTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int employee = current[0];
            int totalInformTime = current[1];

            maxInformTime = Math.max(maxInformTime,totalInformTime);

            for (int subordinate : graph.get(employee)) {
                queue.offer(new int[] {subordinate,totalInformTime + informTime[employee]});
            }
        }

        return maxInformTime;
    }
}
