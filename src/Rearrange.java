import java.util.Arrays;

/**
 * Created by AmitAgarwal on 11/18/18.
 */
public class Rearrange {

    public static void main(String [] args){
        int [] array = {9,6,8,3,10,7};
        rearrangeArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void rearrangeArray(int [] array){
            //start with 2nd element of array and increment with 2
            for(int i=1;i<array.length-1;i+=2){
                if(array[i-1] > array[i]){
                    swap(array,i-1,i);
                }else{
                    swap(array,i+1,i);
                }

                //if next element in greater than current element
                //swap
                if(i+1 < array.length && array[i+1] > array[i]){
                    swap(array,i+1,i);
                }
            }

    }

    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
