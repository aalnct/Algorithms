package restart.graph.again.graphtheory.bfs.hard;

import java.util.*;

public class LandSize {
    /***
     *  find the max landsize
     *  land can be-inform of L shape
     *  traverse 4 directions
     *  have option to convert one water cell to land cell
     *
     *  return maximum land size
     *
     */

    static Map<Integer,Integer> islandSize = new HashMap<>();
    static int [][] DIRECTIONS = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public static void main(String[] args) {
        int [][] matrix = {
                {1,1},
                {1,0}
        };

        System.out.println(largestIsland(matrix));

    }

    static int largestIsland (int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isAllIsland = true; // this is special case where entire grid is island

        for (int i = 0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    isAllIsland = false;
                    break;
                }
            }
        }

        if (isAllIsland) {
            return rows * cols;
        }

        identifyIsland(matrix);

        return findLargestIsland(matrix);
    }

    // this step contains two parts

        // 1. mark islands and identification
        // 2. run bfs and calculate its size
    static void identifyIsland (int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // this will store current island# and its size
        int islandID = 2; // cannot use 0 or 1 since they are used in matrxi for
                             // land and water identification
        boolean [][] visited = new boolean[rows][cols];

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    int size = traverseIslandGrid(matrix, i, j, visited, islandID);
                    islandSize.put(islandID, size);
                    islandID++; // moving to next island with next ID
                }
            }
        }
    }

    private static int traverseIslandGrid (int [][] matrix, int startRow, int startCol, boolean [][] visited, int islandID) {
        int size = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {startRow,startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int [] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            matrix[r][c] = islandID;
            size++;

            for (int [] dir : DIRECTIONS) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols
                && !visited[newRow][newCol] && matrix[newRow][newCol] == 0) {
                    // matrix[newRow][newCol] = islandID;
                    queue.offer(new int [] {newRow,newCol});
                    visited[newRow][newCol] = true;
                    // size++;
                }
            }
        }
        return size;
    }

    static int findLargestIsland (int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSize = 0;

        if (islandSize.isEmpty()) {
            return 1;
        }

        for (int size : islandSize.values()) {
            maxSize = Math.max(maxSize,size);
        }

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    Set<Integer> set = new HashSet<>();

                    for (int [] dir : DIRECTIONS) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                                && matrix[newRow][newCol] >= 2) {
                            set.add(matrix[newRow][newCol]);
                        }
                    }

                    int newSize = 1;
                    for (int id : set) {
                        newSize += islandSize.get(id);
                    }

                    maxSize = Math.max(newSize,maxSize);
                }
            }
        }
        return maxSize;
    }
}
