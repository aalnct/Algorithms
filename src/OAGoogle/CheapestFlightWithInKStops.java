package OAGoogle;

import java.util.*;

public class CheapestFlightWithInKStops {

    public static void main(String[] args) {
        int n = 5;
        int [][] flights = {
                {0,1,5},
                {1,2,5},
                {0,3,2},
                {3,1,2},
                {1,4,1},
                {4,2,1}
        };
        int src = 0;
        int dst = 2;
        int k = 2;

        System.out.println(findCheapestFlight(n,flights,src,dst,k));
    }

    private static int findCheapestFlight (int n, int [][] flights, int src, int dst, int k) {
        // Step 1 : building adjacency graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int [] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[] {to,price});
        }

        // step 2 : Initialize data structure using Dijkstra's algorithm

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // comparing the second element i.e. price
        pq.add(new int[] {src,0,k+1}); // node, price, remaining stops
        Map<Integer,Integer> stopsMap = new HashMap<>();

        for (int i=0; i < n; i++) {
            stopsMap.put(i, Integer.MAX_VALUE);
        }

        //step 3 : start the exploration loop
        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            int currentNode = current[0];
            int currentPrice = current[1];
            int remainingStops = current[2];

            if (currentNode == dst) {
                return currentPrice;
            }

            // if current node is out of stops, continue to next iteration
            if (remainingStops == 0) {
                continue;
            }

            // explore neighbours of the current node
            if (graph.containsKey(currentNode)) {
                for (int [] neighbour : graph.get(currentNode)) {
                    int nextNode = neighbour[0];
                    int nextPrice = currentPrice + neighbour[1];
                    int nextStops = remainingStops-1;

                    // update the stop map if the next price is less then the current recorded price

                    if (nextPrice < stopsMap.get(nextNode)) {
                        stopsMap.put(nextNode, nextPrice);
                        pq.add(new int[] {nextNode,nextPrice,nextStops});
                    }
                }
            }
        }
        return -1;
    }
}
