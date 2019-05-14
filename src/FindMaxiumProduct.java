import java.util.Arrays;

/**
 * Created by AmitAgarwal on 11/18/18.
 */
public class FindMaxiumProduct {

    public static void main(String[] args){
        int [] array = {-10,-3,5,8,-2};
        findMaximumProduct(array);
        findMaximumProduct2(array);
    }


    private static void findMaximumProduct(int [] array){
        Arrays.sort(array);
        int product = Integer.MIN_VALUE;
        int max_i = -1;
        int max_j = -1;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(product < array[i] * array[j]){
                    product = array[i] * array[j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.println("Pair is :" + array[max_i] + " && " + array[max_j]);
    }

    private static void findMaximumProduct2(int [] array){
        int length = array.length;
        Arrays.sort(array);
        if((array[0] * array[1]) > (array[length-1] * array[length-2])){
            System.out.println("** Pair is :" + array[0] + " && " + array[1]);
        }else{
            System.out.println("** Pair is :" + array[length-1] + " && " + array[length-2]);
        }
    }
}
