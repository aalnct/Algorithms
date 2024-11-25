package restart.gemini.graph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        List<String> result = findItinerary(tickets);
        result.forEach(System.out::println);
    }

    static List<String> findItinerary (List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> itinerary = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from,new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("JFK");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            itinerary.add(0,current);

            while (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                String nextAirport = graph.get(current).poll();
                queue.offer(nextAirport);
            }
        }
        Collections.reverse(itinerary);
        return itinerary;
    }
}
