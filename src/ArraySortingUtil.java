/**
 * Created by AmitAgarwal on 11/20/18.
 */
public class ArraySortingUtil {
    public static void main(String [] args){
        int[] array = { 1, 3, 2, 7, 5, 6, 4, 8 };
        findSubArray(array);
    }

    private static void findSubArray(int [] array){
        int leftIndex = -1;
        int rightIndex = -1;

        //traverse from left to right and keep track of maximum so far
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(maxSoFar < array[i]){
                maxSoFar = array[i];
                System.out.println("Max value so far : && " + maxSoFar);
            }
            //find the last position that is less than max so far
            if(array[i] < maxSoFar){
                rightIndex = i;
                System.out.println("right Index updated to : && " + rightIndex);
            }
        }

        //traverse from right to left to keeo track of minimum so far
        int minSoFar = Integer.MAX_VALUE;
        for(int i = array.length-1;i>=0;i--){

            if(minSoFar > array[i]){
                minSoFar = array[i];
            }
            //find the last position that is more than minimum so far
            if(array[i] > minSoFar){
                leftIndex = i;
            }
        }

        System.out.println("Sort array from Index : " + leftIndex + " && " + rightIndex);

    }
}
