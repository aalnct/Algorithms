package leetcode.graph.random.questions;

import java.util.*;

public class InformEmployees {
    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int [] manager = {2,2,-1,2,2,2};
        int [] informTime = {0,0,1,0,0,0};

        System.out.println(informEmployees(n,headID,manager,informTime));
    }

    private static int informEmployees(int n, int headID, int [] manager, int [] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i=0; i < n; i++) {
            if (!adjList.containsKey(manager[i])) {
                adjList.put(manager[i], new ArrayList<>());
            }
            adjList.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {headID,0});

        int totalTime = 0;

        while(!queue.isEmpty()) {
            int [] current = queue.poll();

            int employeeID = current[0];
            int maxTime = current[1];

            totalTime = Math.max(totalTime,maxTime);

            if(adjList.containsKey(employeeID)) {
                for(int subOrdinate : adjList.get(employeeID)) {
                    queue.offer(new int[] {subOrdinate, totalTime + informTime[employeeID]});
                }
            }
        }
        return totalTime;
    }
}
