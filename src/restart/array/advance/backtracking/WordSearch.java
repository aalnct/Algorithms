package restart.array.advance.backtracking;

/**
 * Searching the given word in board
 */
public class WordSearch {

    public static void main(String[] args) {
        char [][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(wordSearch(board,word));
    }

    static boolean wordSearch (char [][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i=0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs (char [][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board,word,i+1,j, index+1)
                ||
                dfs (board,word,i-1,j,index+1) ||
                dfs (board,word,i,j+1,index+1) ||
                dfs (board,word,i, j-1,index+1);

        board[i][j] = temp; // restore it back

        return found;
    }
}
