package restart.graph.hard;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public static void main(String[] args) {
        int [][] grid = {
                {1,2,3},
                {4,0,5}
        };

        System.out.println(slidingPuzzleMove(grid));
    }

    static int slidingPuzzleMove (int [][] grid) {
        StringBuilder start = new StringBuilder();
        String target = "123450";

        for (int i=0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(grid[i][j]); // created string out of grid for easier computation
            }
        }

        int[][] moves = {
                {1, 3},       // 0 -> can move to indices 1, 3
                {0, 2, 4},    // 1 -> can move to indices 0, 2, 4
                {1, 5},       // 2 -> can move to indices 1, 5
                {0, 4},       // 3 -> can move to indices 0, 4
                {1, 3, 5},    // 4 -> can move to indices 1, 3, 5
                {2, 4}        // 5 -> can move to indices 2, 4
        };

        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());

        Set<String> visited = new HashSet<>();
        visited.add(start.toString());

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                String current = queue.poll();

                assert current != null;
                if (current.equals(target)) {
                    return steps;
                }

                int indexOfZero = current.indexOf('0');

                // will swap 0 with other index values
                for (int move : moves[indexOfZero]) {
                    String updatedCurrent = swap(current, indexOfZero, move);

                    if (!visited.contains(updatedCurrent)) {
                        queue.offer(updatedCurrent);
                        visited.add(updatedCurrent);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    static String swap (String current, int indexOfZero, int move) {
        char [] c =  current.toCharArray();
        char temp = c[indexOfZero];
        c[indexOfZero] = c [move];
        c[move] = temp;

        return new String(c);
    }

}
