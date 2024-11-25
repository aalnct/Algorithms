package Sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = { {1,3} , {6,9} };
        int[] newIntervals = {2, 5};

        int[][] mergedIntervals = insert(intervals,newIntervals);

        for (int i = 0; i < mergedIntervals.length; i++) {
            for (int j = 0; j < mergedIntervals[i].length; j++) {
                System.out.print(mergedIntervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    // start by creating a new list called as mergedList to store the merged intervals

    // we iterate through each interval in the intervals array using a variable i
        // if current interval ends before the start of the new interval, it means the current
        // interval doesn't overlap with the new interval.so we add the current interval to the
        // 'merged' list and move to the next interval

        // if the current interval starts after the end of the new interval, we have passed the new interval and its merged range.
        // So, we add the new interval into the merged list and append the remaining intervals to it. then we return the 'merged'
        // list as the final result.

        // If there is an overlap, we update the start and end values of the new interval to cover the merged range. we do this
        // by taking the minimum start and max end value among the current and new intervals.

    // after iterating through the intervals and merging any overlaps intervals, we add the new interval (after merging)
    // to the 'merged' list.

    // Finally, we convert the 'merged' list to a 2D array called 'result' and return it as the final result.


    public static int [][] insert(int[][] intervals, int [] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // add intervals that end before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
        }

        // merged overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        merged.add(newInterval);

        // add remaining intervals
        while ( i < n) {
            merged.add(intervals[i]);
            i++;
        }

        int[][] result = new int[merged.size()][2];
        for (int j = 0; j < merged.size(); j++) {
            result[j] = merged.get(j);
        }

        return result;
    }
}
