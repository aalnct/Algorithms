package fb;

import java.util.HashSet;
import java.util.Set;

public class CheckSumPossible {

    public static void main(String[] args) {
        long[] array = new long[] {2,4,8};
        long k = 5;
        boolean result = checkIfSumPossible(array,k);
        System.out.println(result);

        long[] array1 = new long[] {2,4,6,8,10};
        long k1 = 7;

         result = checkSumPossible(array1,k1);
         System.out.println(result);
    }

    static boolean checkIfSumPossible(long [] array, long k) {
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int i = 0 ; i< array.length;i++) {
            sum = k - array[i];
            if (set.contains(sum)) {
                return true;
            }else  {
                set.add(array[i]);
            }
        }
        return false;
    }
    static boolean checkSumPossible(long [] array, long k) {
        int start = 0;
        int end = array.length-1;
        return helper(array,start,end,k);
    }

    static boolean helper(long[] array, int start, int end, long k) {
        while(start <= end) {
            if (k == array[start] + array[end]) {
                return true;
            } else if (k < array[start] + array[end]) {
                end--;
            } else {
                start ++;
            }
        }
        return false;
    }

    static boolean isSubsetSum(int array[] , int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return true;
        }

        if (array[n-1] > sum) {
            return isSubsetSum(array,n-1,sum);
        }
        return isSubsetSum(array,n-1,sum) || isSubsetSum(array,n-1,sum-array[n-1]);
    }
}
