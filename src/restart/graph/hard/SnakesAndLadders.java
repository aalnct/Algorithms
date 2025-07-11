package restart.graph.hard;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board1 = {
                {-1,-1},{-1,3}
        };

        System.out.println(snakesAndLadders(board1));
    }

    static int snakesAndLadders (int [][] board) {
        int moves = 0;

        int n = board.length;
        boolean [] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                int current = queue.poll();

                if (current == n * n) {
                    return moves;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;

                    if (next > n * n) {
                        break; // cannot go beyond the actual size of board
                    }

                    int [] coordinate = getCoordinates(next,n);
                    int row = coordinate[0];
                    int col = coordinate[1];

                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    static int [] getCoordinates (int square, int n) {

        int row = (square - 1) / n;
        int col = (square - 1) % n;

        if (row % 2 == 1) {
            // for odd rows, reverse the row
            col = n-1-col;
        }
        row = n-1-row;
        return new int [] {row,col};
    }
}