package ds.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * incomplete
 */
public class CountLargestGroup {

    public int countLargestGroup (int n) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=1; i<=n; i++) {
            int sum = digitSum (i);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        int size = map.size();

        int[] groupsFreq = new int[size];
        int i=0;
        for (int g_fre: map.values()) {
            groupsFreq[i] = g_fre;
            i++;
        }
        Arrays.sort(groupsFreq);

        return 0;
    }

    private int digitSum (int num) {
        int sum = 0;
        while (num != 0) {
            sum += num%10;
            num /=10;
        }
        return sum;
    }
}
