package hackerrank.medium.graph;

import java.util.*;

public class JourneyToMoon {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> astronaut = new ArrayList<>();

        astronaut.add(Arrays.asList(0,1));
        astronaut.add(Arrays.asList(2,3));
        astronaut.add(Arrays.asList(0,4));

        System.out.println(journeyToMoon(n,astronaut));
    }

    private static int journeyToMoon(int n, List<List<Integer>> astronauts) {

        List<Integer> [] adjList = new ArrayList[n];

        for (int i=0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(List<Integer> pairs : astronauts) {
            int astronaut1 = pairs.get(0);
            int astronaut2 = pairs.get(1);

            adjList[astronaut1].add(astronaut2);
            adjList[astronaut2].add(astronaut1);
        }

        boolean [] visited = new boolean[n];
        List<Integer> countrySize  = new ArrayList<>();

        for(int i=0; i < n; i++) {
            if (!visited[i]) {
                countrySize.add(bfs(i, adjList,visited));
            }
        }

        int totalWay = 0 ;
        int runningSum = 0;

        int totalSize = countrySize.size();

        for(int i=0; i <totalSize; i++) {
            int size = countrySize.get(i);
            totalWay +=  runningSum * size;
            runningSum +=size;
        }

        return totalWay;

    }

    private static int bfs(int currentCity, List<Integer> [] adjList, boolean [] visited) {
        visited[currentCity] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentCity);

        int size = 1; // for each city size will be 1

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
