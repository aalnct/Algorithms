package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewInterval {

    public static void main(String[] args) {
        int [][] intervals = {
                {1,3},
                {6,9}
        };
        int [] newInterval = {2,5};

        int [] [] result = newIntervals(intervals,newInterval);
        for (int [] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }


    private static int [][] newIntervals (int [][] intervals, int [] newInterval) {
        // already sorted

        // case1 : intervals are ending before new interval starting
        int i=0;
        List<int[]> result = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // case 2 :: overlapping interval, so we merge
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // case 3 :: new interval starts before intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

}
