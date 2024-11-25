package OAOracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        int [][] merged = mergeIntervals(intervals);
        for (int [] i : merged) {
            System.out.println("[" + i[0] + " , " + i[1] + "]");
        }
    }

    public static int[][] mergeIntervals (int [][] intervals) {
        if (intervals == null || intervals.length==0) {
            return new int[0][];
        }
        // sort using the start time so we have the overlapping intervals adjacent
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentIntervals = intervals[0]; // storing the first ...

        for (int i=1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // comparing current interval end time with next interval start time ...
            if (currentIntervals[1] >= nextInterval[0]) {
                currentIntervals[1] = Math.max(currentIntervals[1],nextInterval[1]);
            } else {
                mergedIntervals.add(currentIntervals);
                currentIntervals = nextInterval;
            }
        }
        mergedIntervals.add(currentIntervals);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
