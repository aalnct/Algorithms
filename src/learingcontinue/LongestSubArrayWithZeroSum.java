package learingcontinue;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {

    public static void main(String[] args) {
        int [] array = {1, 2, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(longestSubArray(array));
    }

    private static int findLongestSubArray(int [] array) {
        int n = array.length;
        int maxLength = 0;
        int sum = 0;
        int start = 0;

        for (int i=0; i < n ; i++) {
            sum +=array[i]; // 1
            while (sum != 0 && start <= i) {  // sum is 1, and start is at index 0 and i is also index 0
                sum -=array[start]; // 1-1 --> 0
                start++; // start --> 1
            }

            if (sum == 0) {
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }

        return maxLength;
    }

    private static int longestSubArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i=0;  i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

}
