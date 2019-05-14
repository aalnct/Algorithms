import java.util.*;

/**
 * Created by AmitAgarwal on 11/21/18.
 */
public class FindSubArray {

    public static void main(String [] args){
        /*int [] array = {1,2,3,4,5,6,9,10};
        findSubArray(array);
        fndSubArray2();
        int[] a = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
        array  = new int [] {1,2,3,4,5,6,9,10};
        int sum = 10;
        boolean result  = findSubArray(array,sum);
        if(result){
            System.out.println("Sub-array - exists");
        }else{
            System.out.println("Sub-array - does not exists");
        }*/

        //findSumSubArray();
        findSubArraySum();

    }
    //this approach will only work with positive sum
    private static void findSubArray(int[] array){
        int sum = 10;
        int sumWindow = 0;
        int high = 0;
        int low = 0;

        for(low =0; low < array.length;low++){
            if(sumWindow < sum){
                sumWindow +=array[high];
                high++;
            }

            if(sumWindow == sum){
                //System.out.printf("Subarray found :[%d-%d]\n" + low , high-1);
                System.out.printf("Subarray found [%d-%d]\n", low, high - 1);
                return;
            }
            //at this point current window sum is more than sum
            //remove elements from left
            sumWindow -=array[low];
        }
    }

    //method overloading
    private static boolean findSubArray(int [] array, int sum){
        Set<Integer> set = new HashSet<>();
        //when sub-array starts from 0
        set.add(0);
        int sum_so_far = 0;
        for(int a : array){
            sum_so_far +=a;
            if(set.contains(sum_so_far-sum)){
                return true;
            }
            //else insert sum of elements into set
            set.add(sum_so_far);
        }
        return false;
    }

    private static void fndSubArray2(){
        int sum = 14;
        int windowSum = 0;
        int [] array = {5,5,5,4,1,1};
        Set<Integer> set = new HashSet<>();
        set.add(sum);

        Set<Integer> setOfSum = new HashSet<>();
        setOfSum.add(0);
        for(int i=0;i<array.length;i++){
            if(!setOfSum.containsAll(set)){
                windowSum +=array[i];
                setOfSum.add(windowSum);
            }else{
                System.out.println("printing : {} {} sub array exisits");
                break;
            }
        }
    }

    private static void findSumSubArray(){
        int [] array = {4,1,8,1,9,3,0,2,1,4,2};
        List<Integer> list = new ArrayList<>(array.length);
        int sum = 6;
        int windowSum = 0;
        for(int i : array){
            if(i < sum){
                //only when element is less than sum we will add and check whether addition is equal to sum
                windowSum += i;
                list.add(i);
                if(windowSum == sum){
                    System.out.println("Sum is equal in sub-array");
                    windowSum = 0;
                    continue;
                }

            }
        }
        //printing sub-array elements whose addition is equal to sum
        list.forEach(System.out::println);
        //System.out.print(list.toArray().toString());
    }

    private static void findSubArraySum(){
        int [] array = {4,1,8,1,9,3,0,2,1,4,2};
        int sum = 6;
        int currSum = array[0];
        int start = 0;
        int end = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] < sum){
                while(end < array.length){
                    if(currSum == sum){
                        System.out.print("Found given sum :" + start + " to " + end);
                    }
                    if(currSum <= sum){
                        end++;
                        if(end < array.length){
                            currSum += array[end];
                        }
                    }else {
                        currSum -=array[start];
                        start++;
                    }
                }
            }

        }

    }
}
