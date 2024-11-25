package restart.array.intermidiate;

import threading.AtomicIntegerExample;

import java.util.Arrays;

public class MinimumHeight2 {

    public static void main(String[] args) {
        int[] arr = {1 ,8 ,10 ,6 ,4 ,6 ,9 ,1};
        int k = 7;

        System.out.println(minimumHeight(arr,k));
    }

    static int minimumHeight (int [] array, int k) {

        if (array.length == 1) {
            return 0;
        }

        Arrays.sort(array);

        int initialDifference = array[array.length-1] - array[0];
        int minHeight = array[0] + k;
        int maxHeight = array[array.length-1] - k;

        int result = initialDifference;

        for (int i=1; i < array.length; i++) {
            int minimumDifference = Math.min(minHeight, array[i] - k);
            int maximumDifference =  Math.max(maxHeight, array[i-1] + k);

            if (minimumDifference >= 0) {
                result = Math.min(result, maximumDifference - minimumDifference);
            }
        }
        return result;
    }
}
