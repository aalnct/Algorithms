import java.util.Arrays;

/**
 * Created by AmitAgarwal on 11/15/18.
 */
public class ThreeWayPartiotion {

    public static void main(String[] args){
        int [] array = {0,1,2,2,1,0,0,2,0,1,1,0};
        threeWayPartition(array,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void threeWayPartition(int[] array, int end){
        int start = 0;
        int mid = 0;
        //create a pivot
        int pivot = 1;

        while(mid <= end){
            if(array[mid] < pivot){
                swap(array,start,mid);
                ++start;
                ++mid;
            }else if(array[mid] > pivot){
                swap(array,mid,end);
                --end;
            }else{
                ++mid;
            }
        }

    }

    private static void swap(int[] array, int start, int mid) {
        int temp = array[start];
        array[start] = array[mid];
        array[mid] = temp;
    }


}
