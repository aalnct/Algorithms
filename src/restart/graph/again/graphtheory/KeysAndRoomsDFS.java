package restart.graph.again.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRoomsDFS {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(0, Arrays.asList(1,3));
        graph.add(1, Arrays.asList(0,2));
        graph.add(2, Arrays.asList(1));
        graph.add(3, new ArrayList<>());

        System.out.println(keysAndRooms(graph));
    }

    static boolean keysAndRooms (List<List<Integer>> rooms) {

        int size = rooms.size();
        boolean [] visited = new boolean[size];

        dfs(rooms, 0,visited);

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    static void dfs (List<List<Integer>> rooms, int start, boolean [] visited) {
        visited[start] = true;

        for (int keys : rooms.get(start)) {
            if (!visited[keys]) {
                dfs(rooms,keys,visited);
            }
        }
    }
}
