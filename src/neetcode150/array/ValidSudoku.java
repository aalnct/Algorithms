package neetcode150.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char [][] grid = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(validSudoku(grid));
    }

    static boolean validSudoku (char [][] grid) {

        Set<Character> [] rows = new HashSet[9];
        Set<Character> [] cols = new HashSet[9];
        Set<Character> [][] boxes = new HashSet[9][9];

        for (int i=0; i < 9; i ++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3;  j++) {
                boxes[i][j] = new HashSet<>();
            }
        }

        // looping through each cell

        for (int r=0; r < 9; r++) {
            for (int c=0;c<9;c++) {
                char val = grid[r][c];

                if (val == '.') {
                    continue;
                }

                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                if (boxes[r/3][c/3].contains(val)) {
                    return false;
                }
                boxes[r/3][c/3].add(val);
            }
        }
        return true;
    }


}