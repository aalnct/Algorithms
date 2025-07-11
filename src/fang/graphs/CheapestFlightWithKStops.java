package fang.graphs;

import java.util.Arrays;

public class CheapestFlightWithKStops {

    public static void main(String[] args) {
        int n = 4;
        int [][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestFlight(n,flights,src,dst,k));
    }

    static int findCheapestFlight (int n, int [][] flights, int src, int dst, int k) {
        int [] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);

        costs[src] = 0;

        for (int i=0; i <=k; i++) {

            int [] temp = costs.clone();

            for (int [] flight : flights) {
                int from = flight[0];
                int to =flight[1];
                int price = flight[2];

                if (costs[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], costs[from] + price);
                }
            }
            costs = temp;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
