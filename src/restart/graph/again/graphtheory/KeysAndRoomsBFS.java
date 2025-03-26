package restart.graph.again.graphtheory;

import java.util.*;

public class KeysAndRoomsBFS {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(0, Arrays.asList(1,3));
        graph.add(1, Arrays.asList(0,2));
        graph.add(2, Arrays.asList(1));
        graph.add(3, new ArrayList<>());

        System.out.println(visitAllRooms(graph));
    }

    static boolean visitAllRooms (List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0); // starting room
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : rooms.get(current)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

}
