import java.util.Arrays;

/**
 * Created by Amit Agarwal on 11/20/18.
 */
public class ArrayIndexUpdate {

    public static void main(String [] args){
        /*int [] array = {0,6,0,8,2,3,0,4,0,1};*/
        int [] array = {0,6,0,8};
        //updateIndex(array);
        //System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void updateIndex(int [] array){

        int k = 0; //stores next available position
        for(int i : array){
            if(i!=0){
                array[k++] = i;
            }
        }

        for(int i=k;i<array.length;i++){
            array[i] = 0;
        }

    }

    private static void quickSort(int [] array){
        int j = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=0){
                swap(array,i,j);
                j++;
            }
        }
    }

    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println("Temp {} {} :  " + temp);
        System.out.println("Array [i] {} {} : " + array[i]);
        System.out.println("Array [j] {} {} : " + array[j]);
    }

}
