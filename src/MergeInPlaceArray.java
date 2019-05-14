import java.util.Arrays;

/**
 * Created by AmitAgarwal on 11/15/18.
 */
public class MergeInPlaceArray {

    public static void main(String[] args){
        int[] array1 = {1,4,5,8,10};
        int [] array2 = {2,3,9};
        merge(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void merge(int [] array1, int[] array2){
        int m = array1.length;
        int n = array2.length;

        for(int i=0;i<m;i++){
            if(array1[i] > array2[0]){
                //swap
                int temp = array1[i];
                array1[i] = array2[0];
                array2[0] = temp;

                int first = array2[0];

                //move array2[0] to its correct position
                int k;
                for(k=1;k<n && array2[k] < first;k++){
                    array2[k-1] = array2[k];
                }
                array2[k-1] = first;
            }
        }
    }
}
