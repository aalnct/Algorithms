package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergedIntervals {

    public static void main(String[] args) {
        int [][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int [][] result = mergedIntervals(intervals);

        for (int [] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    static int [] [] mergedIntervals (int [][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int [0][0];
        }

        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int [] currentInterval = intervals[0];

        for (int i=1; i < intervals.length; i++) {
            int [] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}
