package restart.gemini.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = nQueenProblem(n);

        for (List<String> s : result) {
            for (String _s : s) {
                System.out.print(s);
            }
        }
    }

    static List<List<String>> nQueenProblem (int n) {
        char [][] board = new char[n][n];

        // first construct empty board
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> solution = new ArrayList<>();
        solveNQueen(board,solution,0,n);
        return solution;
    }

    static void solveNQueen (char [][] board, List<List<String>> solution, int row, int n) {
        if (row == n) {
            solution.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board,row,col, n)) {
                board[row][col] = 'Q';
                solveNQueen(board,solution,row+1, n);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe (char [][] board, int row, int col, int n) {
        // we will check three ways
        // 1. same row
        // 2. upper row left col
        // 3. upper row, right col


        for (int i=0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i=row-1, j = col-1; i>=0 && j >=0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i=row-1, j = col+1; i>=0 && j<n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    static List<String> construct (char [][] board) {
        List<String> result = new ArrayList<>();
        for (char [] b : board) {
            result.add(new String(b));
        }
        return result;
    }
}
