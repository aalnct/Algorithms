package restart.array.advance;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char [][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

                };

        System.out.println( isValidSudoku(board) );
    }

    static boolean isValidSudoku (char [][] board) {
        Set<Character> [] rows = new HashSet [9];
        Set<Character> [] cols = new HashSet [9];
        Set<Character> [] boxes = new HashSet [9];

        for (int i=0; i < 9; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                boxes[i] = new HashSet<>();
        }

        // Iterate through each cell
        for (int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') { // we check only filled boxes
                    // calculate index for each row/col
                    int boxIndex = (i/3) * 3 + (j/3);

                    if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                        return false;
                    }

                    // else we will add the character
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }
        return true;
    }
}
