package restart.array.intermidiate;

import java.util.Arrays;

public class CountUnguardedCells {

    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguardedCells(m,n,guards,walls));
    }

    static int countUnguardedCells (int m, int n, int [][] guards, int [][] walls) {

        char [][] grid = new char[m][n];

        for (char [] rows : grid) {
            Arrays.fill(rows,'E'); // 'E' represents empty
        }

        // fill up grid with Guards
        for (int [] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }

        // fill up with walls
        for (int [] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        // now start checking with guard visibility
        for (int [] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            propogate(grid,x,y,-1,0); // going up
            propogate(grid,x,y,1,0); // going down
            propogate(grid,x,y,0,-1); // going left
            propogate(grid,x,y,0,1); // going right
        }

        int unguardedGrid = 0;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    unguardedGrid++;
                }
            }
        }
        return unguardedGrid;
    }

    static void propogate (char [][] grid, int x, int y, int dx, int dy) {
        int m = grid.length;
        int n = grid[0].length;

        x +=dx;
        y +=dy;

        // within grid
        while (x >=0 && x < m && y >=0 && y < n) {
            if (grid[x][y] == 'W' || grid[x][y] == 'G') {
                break;
            }

            if (grid[x][y] == 'E') {
                grid[x][y] = 'X'; // marking the unblocked grid as 'X'
            }
            x +=dx;
            y +=dy;
        }
    }

}
