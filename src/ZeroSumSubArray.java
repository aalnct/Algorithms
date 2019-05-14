import java.util.HashSet;
import java.util.Set;

/**
 * Created by AmitAgarwal on 11/14/18.
 */
public class ZeroSumSubArray {

    public static void main(String[] args){
        int [] array = {4,-6,3,-1,4,2,7};
        int [] array2 = {3,4,-7,3,1,3,1,-4,-2,-2};
        zeroSumSubArray(array);
        if(zeroSumSubArray(array)){
            System.out.println("Subarray exists");
        }else{
            System.out.println("Subarray does not exists");
        }

        printAllSubArrayS1(array2);

    }

    private static boolean  zeroSumSubArray(int [] array){
        Set<Integer> set  = new HashSet<>();
        set.add(0);
        int sum = 0;
        for(int i=0;i<array.length;i++){
        //sum of elements so far
            sum += array[i];
            if(set.contains(sum)){
                System.out.println("Array Element :" + array[i]);
                return true;
            }
            set.add(sum);
        }
        return false;
    }
    /**
     * Print all arrays with 0 sum
     */
    //Solution 1

    public static void printAllSubArrayS1(int [] array){
        for(int i=0;i<array.length;i++){
            int sum = 0;
            for(int j=i;j<array.length;j++){
                sum +=array[j];
                //if sum is seen before
                if(sum == 0){
                    System.out.println("SubArray [" + i + ".." + j + "] ");
                }
            }
        }
    }

}
