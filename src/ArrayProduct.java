/**
 * Created by AmitAgarwal on 11/20/18.
 */
public class ArrayProduct {

    public static void main(String [] args){
        int [] array = {1,2,3,4,5};
        findProduct(array);
    }


    private static void findProduct(int [] array){
        //left and right sub-array
        int n = array.length;
        int left [] = new int[array.length];
        int right [] = new int[array.length];

        //left - 0...i-1
        left[0] = 1;
        for(int i=1;i<array.length;i++){
            left[i] = array[i-1] * left[i-1];
        }

        //right - i+1....n-1 (n--> length of array)
        right[array.length-1] = 1; //array end - initlialized with 1
        for(int j = n-2; j>=0;j--){
            right[j] = array[j+1] * right[j+1];

        }
    }
}
