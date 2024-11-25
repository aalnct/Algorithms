package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {
        int [][] intervals = {
                {0,30},
                {5,10},
                {15,20}
        };

        System.out.println(meetingRooms(intervals));
    }

    private static int meetingRooms(int [][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // sorting based on start time ...
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // initially add the end time of first meeting
        minHeap.offer(intervals[0][1]); // 0 array , index 1 which is end time of current meeting

        for (int i=1; i < intervals.length; i++) {
            int currentStarTime = intervals[i][0]; // current start time
            int earliestEndTime = minHeap.peek();

            if (currentStarTime >= earliestEndTime) {
                minHeap.poll();
            }

            // add the new endtime to the minHeap
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size(); // size of the heap defines the number of rooms needed for the meeting ...
    }
}
