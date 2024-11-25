package restart.array.basic;

public class Max1Row {

    public static void main(String[] args) {
        int [][] array = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        System.out.println(max1Row(array));
    }


    static int max1Row (int [][] array) {
        int n = array.length;
        int m = array[0].length;
        int max1Row = -1;
        int j = m-1; // starting from right most column

        for (int i=0; i < n; i++) {
            while (j >=0 && array[i][j] == 1) {
                j--;
                max1Row = i;
            }
        }
        return max1Row;
    }
}
