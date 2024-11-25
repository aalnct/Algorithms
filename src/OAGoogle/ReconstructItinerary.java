package OAGoogle;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

       // findItinerary(tickets).forEach(System.out::println);

        System.out.println("/n");
        findItinerary_2(tickets).forEach(System.out::println);

    }


    private static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> itinerary = new ArrayList<>();

        // build the graph
        for (List<String> ticket : tickets) {
            String from  = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("JFK");

        while (!queue.isEmpty()) {
            String airport = queue.poll();
            itinerary.add(0,airport); // add the dequeued airport at the begining of the list

            while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
                String nextAirport = graph.get(airport).poll();
                queue.offer(nextAirport);
            }
        }

        Collections.reverse(itinerary);

        return itinerary;
    }

    // use the approach of tree map

    private static List<String> findItinerary_2 (List<List<String>> tickets) {
        Map<String,TreeMap<String,Integer>> graph = new HashMap<>();
        List<String> itinerary = new ArrayList<>();

        // build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new TreeMap<>());
            graph.get(from).put(to,graph.get(from).getOrDefault(to,0)+1);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("JFK");

        while (!queue.isEmpty()) {
            String airport= queue.poll();

            while (graph.containsKey(airport)
                    && !graph.get(airport).isEmpty()) {
                String nextAirport = graph.get(airport).firstKey();
                int count = graph.get(airport).get(nextAirport); // how many tickets left

                if (count == 1) {
                    graph.get(airport).remove(nextAirport);
                } else {
                    graph.get(airport).put(nextAirport, count -1); // reduce the number of tickets left from the airport
                }
                queue.offer(nextAirport);
            }
            itinerary.add(airport);
        }
        Collections.reverse(itinerary);

        return itinerary;
    }
}
