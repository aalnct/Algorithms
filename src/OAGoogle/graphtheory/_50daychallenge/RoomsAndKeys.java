package OAGoogle.graphtheory._50daychallenge;

import java.util.*;

public class RoomsAndKeys {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        /*rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));*/

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        Set<Integer> visitedRooms = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visitedRooms.add(0);

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();

            List<Integer> keys = rooms.get(currentRoom);

            for (int key : keys) {
                if (!visitedRooms.contains(key)) {
                    visitedRooms.add(key);
                    queue.add(key);
                }
            }
        }
        return visitedRooms.size() == totalRooms;
    }
}
