import java.util.stream.IntStream;

/**
 * Created by AmitAgarwal on 11/19/18.
 */
public class EquilibriumIndex {

    public static void main(String[] args){
        int [] array = {0,-3,5,-4,-2,3,1,0};
        equilibriumIndex(array);
        equilibriumIndex2(array);
    }

    //this will be with O(n) for both time and space complexity
    private static void equilibriumIndex(int [] array){
        //left[i] stores sum of elements of sub-array A[0...i-1]
        int [] left = new int[array.length];   //created an array with length equal to original array
        //traverse array from left to right
        for(int i=1;i<array.length;i++){
            left[i] = left[i-1] + array[i-1];
        }
        //right stores the sum of sub array Array[i+1.......n]
        int right = 0;
        //traverse from right to left
        for(int i=array.length-1;i>=0;i--){
            if(left[i] == right){
                System.out.println("Equilibrium index found at " + i);
            }

            right +=array[i];
        }
    }

    //this will be with O(1)
    private static void equilibriumIndex2(int [] array){
        //total stores sum of all elements of the array
        int total = IntStream.of(array).sum();//java 8
        //right stores sum of elements of sub array array[i+1.....n]
        int right = 0;
        //right to left
        for(int i=array.length-1;i>=0;i--){
            //sum of elements of left sub-array
            if(right == total - (array[i] + right)){
                System.out.println("Equilibrium index ::: {} {} " + i);
            }
            right +=array[i];
        }
    }

}
