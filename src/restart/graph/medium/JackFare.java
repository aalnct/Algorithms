package restart.graph.medium;

import java.util.*;

public class JackFare {

    public static void main(String[] args) {
        int gNodes = 4;
        List<Integer> gFrom = Arrays.asList(1, 1, 2, 3);
        List<Integer> gTo = Arrays.asList(2, 3, 4, 4);
        List<Integer> gWeight = Arrays.asList(20, 5, 30, 40);

        findMinFare(gNodes,gFrom, gTo, gWeight);

    }

    static void findMinFare (int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {

        List<List<int []>> graph = new ArrayList<>();

        for (int i=0; i < gNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i < gFrom.size(); i++) {
            int u = gFrom.get(i) - 1;
            int v = gTo.get(i) - 1;
            int weight = gWeight.get(i);

            graph.get(u).add(new int[] {v,weight});
            graph.get(v).add(new int[] {u, weight});
        }

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int [] minFare = new int[gNodes];
        Arrays.fill(minFare,Integer.MAX_VALUE);
        minFare[0] = 0; // starting point will have 0 cost, right

        pq.offer(new int[] {0,0});

        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            int currentNode  = current[0];
            int currentFare = current[1];


            if (currentNode == gNodes -1 ) {
                System.out.println("The lowest fare from station 0 to station " + (gNodes - 1) + " is: " + currentFare);
                return;
            }

            // exploring neighbours
            for (int [] neighbours : graph.get(currentNode)) {
                int nextNode = neighbours[0];
                int nextFare = neighbours[1];

                int newFare = currentFare + Math.max(0, nextFare - currentFare);

                if (newFare < minFare[nextNode]) {
                    minFare[nextNode] = newFare;
                    pq.offer(new int [] {nextNode, nextFare});
                }
            }
        }
        System.out.println("Distance total cost is " + - 1);
    }
}