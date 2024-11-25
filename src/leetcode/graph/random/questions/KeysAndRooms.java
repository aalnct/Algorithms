package leetcode.graph.random.questions;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRoom = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty()) {
            int currentRoom = queue.poll();

            List<Integer> currentKey = rooms.get(currentRoom);

            for(int key : currentKey) {
                if(!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }
        return visited.size() == totalRoom;
    }
}
