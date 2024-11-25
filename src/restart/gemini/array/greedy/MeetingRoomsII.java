package restart.gemini.array.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // we have to return minimum number of rooms needed for the meeting

    public static void main (String [] args) {
        int [][] intervals = {
                {0,30},
                {5,10},
                {15,20}
        };

        System.out.println(meetingRoomsII(intervals));
    }

    static int meetingRoomsII (int [][] intervals) {
        // we are going to use priority queue

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]); // adding current interval end time

        for (int i=1; i < intervals.length; i++) {
            int currentStartTime = intervals[i][0];
            int maxEndTime = minHeap.peek();

            if (currentStartTime >= maxEndTime) {
                minHeap.poll(); // that means I do not need one more room since my current meeting is ending before the next meeting starts
            }

            minHeap.offer(intervals[i][1]); // add current interval end time
        }
        return minHeap.size();
    }
}
