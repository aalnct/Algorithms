package restart.array.advance.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void main(String[] args) {
        List<List<String>> solution = solveNQueens(4);
        for (List<String> solve : solution) {
            for (String row : solve) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    private static List<List<String>> solveNQueens (int n) {
        List<List<String >> solution = new ArrayList<>();
        char [][] board = new char[n][n];

        // populate the board with empty space
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve (solution,board,0,n);
        return solution;
    }

    private static void solve (List<List<String >> solution, char[][] board, int row, int n) {
        if (row == n) {
            solution.add(construct(board));
            return;
        }

        for (int col=0; col < n; col++) {
            if (isSafe(board,row,col,n)) {
                board[row][col] = 'Q';
                solve(solution,board,row+1,n);
                // finally backtracking
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe (char[][] board, int row, int col, int n) {
        // first we check column
        for (int i=0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check upper left row diagonal
        for (int i= row-1, j = col-1; i>=0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check upper right diagonal
        for (int i=row-1, j= col+1; i >=0 && j < n; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> construct (char [][] board) {
        List<String> result = new ArrayList<>();
        for (char[] chars : board) {
            result.add(new String(chars));
        }
        return result;
    }
}
