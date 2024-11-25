package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergedInterval_2 {

    public static void main(String[] args) {
        int [][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int [][] result =mergeInterval(intervals);
        for (int [] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    private static int [][] mergeInterval (int [][] intervals) {
        List<int []> mergedInterval = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return null;
        }

        // [1, 3] store 3 in current interval
        Arrays.sort(intervals, Comparator.comparingInt(a ->a[0]));
        int [] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int [] nextInterval = intervals[i];
            if (currentInterval [1] >= nextInterval[0]) {
                currentInterval [1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedInterval.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedInterval.add(currentInterval);
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}