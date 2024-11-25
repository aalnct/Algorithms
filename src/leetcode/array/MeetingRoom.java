package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    public static void main(String[] args) {
        int [][] intervals = {
                {7,10}, //
                {2,4}, //
                {11,15} //
        };

        System.out.println(canAttendMeetings(intervals));
    }

    private static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // compare start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i=1; i < intervals.length; i++) {
            // compare end time of first array with the end time of second array
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }

}
