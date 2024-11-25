package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewInterval_2 {

    public static void main(String[] args) {
        int [][] intervals = {
                {1,3}, {6,9}
        };
        int [] newIntervals = {
                2,5
        };
        System.out.println(Arrays.deepToString(insertNewInterval(intervals,newIntervals)));
    }

    static int [][]  insertNewInterval (int [][] intervals, int [] newInterval) {
        List<int []> merged = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // case 1 : when current interval ends before new interval
        while (i < n && intervals[i][1] < newInterval[0]) { // 1,3
                                                            // 2, 5
            merged.add(intervals[i]);
        }
        // case 2 : when new interval and current interval merged
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        // case 3 : when new interval ends before current interval
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }
        return merged.toArray(new int [merged.size()][]);
    }
}