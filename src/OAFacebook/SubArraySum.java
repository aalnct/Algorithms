package OAFacebook;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        int [] nums = {1,2,1,2,1};
        int k = 3;
        System.out.println(subArraySum(nums,k));
    }

    static int subArraySum(int [] nums, int k) {
        int sum = 0;
        int count = 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            for (int j=0; j <= i; j++) {
                if (map.containsKey(k-sum)) {
                    count += map.get(k-sum);
                }
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
