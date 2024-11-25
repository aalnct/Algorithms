package OAFacebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3}, {2,6}, {8,10},{15,18}
        };

        int [][] result = mergeIntervals(intervals);

        for (int [] r : result) {
            System.out.println(Arrays.toString(r));
        }

    }

    static int[][] mergeIntervals(int [][] intervals) {
        if (intervals == null || intervals.length == 0 ) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] currentInterval = intervals[0];
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i=1; i < intervals.length; i++) {
            int [] nextInterval = intervals[i];

            // if end of current is bigger than start of next, so we merge
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        // add the last interval here ...
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
