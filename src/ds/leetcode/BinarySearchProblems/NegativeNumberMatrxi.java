package ds.leetcode.BinarySearchProblems;

/**
 * Created by AmitAgarwal on 5/14/20.
 */
public class NegativeNumberMatrxi {

    public static void main(String[] args) {
        /*int[][] array = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2} ,  {-1,-1,-2,-3}};*/
        /*int[][] array = {{3,2}, {1,0}};*/
        /*int[][] array = {{1,-1}, {-1,-1}};*/
        int[][] array = {{-1}};
        int count = countNegatives(array);
        System.out.println(count);
    }

    public static int countNegatives(int[][] array){
        // two dimensional array
        int count = 0;
        for(int row = 0;row < array.length;row++){
            for(int col = 0; col < array[row].length;col++){
                if(array[row][col] < 0){
                    count++;
                }
                continue;
            }
        }
        return count;
    }

}
