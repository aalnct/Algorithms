package ds.sorting;

/**
 * Created by AmitAgarwal on 5/5/20.
 */
public class InsertionSort {

    private static int[] array = {-1, 20,1,7,30,5,8, -9};

    private static int[] insertionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int element = array[i]; //the value that needs to be bring to sorted place
            int j= i-1;
            while(j>=0 && array[j] > element){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]  = element;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a =  insertionSort(array);
        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
