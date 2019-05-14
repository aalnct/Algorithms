import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by AmitAgarwal on 11/15/18.
 */
public class FindDuplicate {

    public static void main(String [] args){
        int[] array = {2,1,3,9,1};
        isDuplicate(array);
        sumOfArrayElements(array);
    }

    /**
     *
     * @param array
     * @return
     *
     * Hashing to check if duplicate element exists in map
     */
    public static boolean isDuplicate(int [] array){
        boolean isElementDuplicate = false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<array.length;i++){
            if(map.containsKey(array[i])){
                isElementDuplicate = true;
                System.out.println("Duplicate element found :" + array[i]);
                continue;
            }else{
                map.put(array[i], array[i]);
                System.out.println("Element inserted in map :" + map.get(array[i]));
            }
        }
        return isElementDuplicate;
    }


    private static boolean sumOfArrayElements(int [] array){
        int actualSum = 0;
        boolean isDuplicatePresent = false;

        if(array.length>0){
            actualSum = IntStream.of(array).sum();
        }

        for(int i=0;i<array.length;i++){
            for(int j = i+1;i<array.length-1;i++){
                if((actualSum-array[i]) == (actualSum-array[j])){
                    System.out.println("Duplicate value present in array :" + array[i] + " " + array[j]);
                }else{
                    System.out.println("Duplicate not found for current iteration :" +
                            "" + (actualSum-array[i]) + " && " + (actualSum-array[j]));
                }
            }
        }

        System.out.println("***********");

        return isDuplicatePresent;
    }

}
