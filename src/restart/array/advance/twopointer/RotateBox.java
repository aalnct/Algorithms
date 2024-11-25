package restart.array.advance.twopointer;

import java.util.Arrays;

public class RotateBox {

    public static void main(String[] args) {
        char [][] box = {
                {'#', '.', '#'}
        };

        for (char [] row : rotateBox(box)) {
            System.out.println(Arrays.toString(row));
        }

    }

    static char [][] rotateBox (char [][] box) {
        int m = box.length; // number of rows
        int n = box[0].length; // number of columns

        for (int i=0; i < m; i++) { // so we start from first row
            int writePointer = n-1;
            for (int j = n-1; j >=0; j--) { // but we start from lsat column of that row
                if (box[i][j] == '#') {
                    box[i][writePointer] = '#';  // so my write pointer did not move yet, if during traversal i
                    // encountered stone, that will move to my position of write pointer, and then write pointer will move
                    if (writePointer != 'j') {
                        // clear original position from where stone fall
                        box[i][j] = '.';
                    }
                    writePointer--;
                } else if (box[i][j] == '*') {
                    // obstacle cannot be moved
                    // so move one place above obstacle
                    writePointer = j-1;
                }
            }
        }

        // now rotate the box 90 degress
        char [][] rotatedBox = new char[n][m];
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                rotatedBox[j][m-1-i] = box[i][j];
            }
        }
        return rotatedBox;
    }
}
