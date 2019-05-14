import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class ArrayMaximumSum {
    public static void main(String[] args){
        Integer [] array = {4,6,2,7,9,8};
        maximumSum(array);
    }

    private static void maximumSum(Integer [] array){

        /**
         * two variable x and y - odd and even indices
         */
        Arrays.sort(array, Comparator.reverseOrder());

        int x = 0, y =0;
        //even indices
        for(int i=0; i <array.length; i=i+2){
            x = x * 10 + array[i];
        }

        //odd indices
        for(int i=1; i<array.length; i = i+2){
            y = y * 10 + array[i];
        }

        System.out.print("two numbers with maximum sum are : " + x + " && " + y);

    }
}
