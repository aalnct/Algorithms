package leetcode.graph.bfs;

import java.util.*;

public class ShortestPathLeftToRight {

    public static void main(String[] args) {

    }

    static int [][] DIRECTIONS = {
            {1,0} , {0,1}, {0,-1}, {-1,0}
    };

    private static String encode (int [] cell) {
        return cell[0] + "" + cell[1];
    }

    private static List<int[]> findPath (int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean [][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();

        for (int i=0; i < rows; i++) {
            if (grid[i][0] == 0) {
                int [] start = new int[] {i,0};
                queue.offer(start); // fill up the queue with all 0s (all clear cells)
                visited[i][0] = true;
                parent.put(encode(start),null); // no parent for the source
            }
        }
        int [] destination = null;
        while (!queue.isEmpty()) {
            int [] curr = queue.poll();
            if (curr[1] == cols-1) {
                destination = curr;
                break;
            }
            for (int [] dir : DIRECTIONS) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols
                && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {

                    int [] next = new int [] {newRow,newCol};
                    queue.offer(next);
                    visited[newRow][newCol] = true;
                    parent.put(encode(next),encode(curr));
                }
            }
        }
        if (destination == null) {
            return new ArrayList<>();
        }

        // construct path
        List<int []> path = new ArrayList<>();
        String currKey = encode(destination);
        while (currKey != null) {
            String [] parts = currKey.split(",");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            path.add(new int [] {row,col});
            currKey = parent.get(currKey);
        }
        Collections.reverse(path);
        return path;
    }
}
