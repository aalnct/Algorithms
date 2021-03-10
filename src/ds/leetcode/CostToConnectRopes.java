package ds.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CostToConnectRopes {

    private static List<Integer> list = new ArrayList<>();

    public static int minCost (List<Integer> ropes) {
        Queue<Integer> queue = new PriorityQueue<>(ropes);
        int totalCost = 0;
        while (queue.size() > 1) {
            int cost = queue.poll() + queue.poll();
            queue.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        list.add(20);
        list.add(4);
        list.add(8);
        list.add(2);
        int minCost = minCost(list);
        System.out.println(minCost);
    }

}
