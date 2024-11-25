package learingcontinue;

public class WordSearch {

    public static void main(String[] args) {
        int [][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "AAB";
        System.out.println(wordSearch(board,word));
    }

    public static boolean wordSearch(int [][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i=0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                if (dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int [][] board, String word, int row, int column, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
                column < 0 || column >= board[0].length
        || board[row][column] != word.charAt(index)) {
            return false;
        }

        board[row][column] = '#'; // marking the cell as visited

        boolean found = dfs(board,word, row+1, column, index + 1)
                || dfs(board,word, row-1, column, index + 1)
                || dfs(board,word, row, column+1, index + 1)
                || dfs(board,word, row, column-1, index + 1);

        board[row][column] = word.charAt(index); // marking the node as unvisited

        return found;
    }
}
