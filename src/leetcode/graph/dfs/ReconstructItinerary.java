package leetcode.graph.dfs;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        // tickets.add(Arrays.asList("ATL", "JFK"));
        // tickets.add(Arrays.asList("ATL", "SFO"));

        System.out.println(reconstructItinerary(tickets));
        System.out.println(reconstructItineraryBFS(tickets));
    }

    private static List<String> reconstructItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();

        // build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            // if not present, add it
            graph.computeIfAbsent(from, k-> new ArrayList<>()).add(to);
        }

        // sort the destination lexicographically
        for (List<String> destination : graph.values()) {
            Collections.sort(destination);
        }

        // start dfs from "JFK"
        //[JFK, ATL, JFK, SFO, ATL]
        dfs("JFK", graph, result, tickets.size() + 1);

        return result;
    }

    private static boolean dfs(String from, Map<String,List<String>> graph, List<String> result, int targetLength) {
        result.add(from); // we will start from here in 1st iteration ...

        if (result.size() ==  targetLength) {
            return true; // valid Itinerary found
        }

        if (graph.containsKey(from)) {
            List<String> destination = graph.get(from);
            for (int i=0; i < destination.size(); i++) {
                String to = destination.get(i);
                destination.remove(i); // to avoid going to same destination again

                if (dfs(to,graph,result,targetLength)) {
                    return true;
                }
                destination.add(i, to); // Backtrack
            }
        }
        // needed to backtrack to find other valid paths
        result.remove(result.size()-1);
        return false;
    }

    private static List<String> reconstructItineraryBFS(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String,PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from, k-> new PriorityQueue<>()).offer(to);
        }

        Stack<String> stack = new Stack<>();
        String currentAirport = "JFK";
        stack.push(currentAirport);

        while (!stack.isEmpty()) {
            PriorityQueue<String> destination = graph.get(currentAirport);
            if (destination != null && !destination.isEmpty()) {
                String nextAirport = destination.poll();
                stack.push(nextAirport);
                currentAirport = nextAirport;
            } else {
                // if no more destination left, add the airport to the Itinerary
                result.add(0,stack.pop());
                if(!stack.isEmpty()) {
                    currentAirport = stack.peek();
                }
            }
        }
        return result;
    }
}