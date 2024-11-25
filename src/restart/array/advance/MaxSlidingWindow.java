package restart.array.advance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution using Max_Heap approach
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int [] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    static int [] maxSlidingWindow ( int [] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int [] {0};
        }

        int n = nums.length;
        int [] result = new int[n-k+1]; // size of window is size of resultant array
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> b[0] - a[0]);

        // first fill the initial window
        for (int i=0; i < k; i++) {
            maxHeap.offer(new int [] {nums[i] , i});
        }

        // fill the resultant array with that

        result[0] = maxHeap.peek()[0];

        // now we will start adding new elements in heap
        for (int i=k ; i < n; i++) {
            maxHeap.offer(new int [] {nums[i],i});

            // start removing element that are outside window
            // index less than or equal to i-k
            while (maxHeap.peek()[1] <= i-k) {
                maxHeap.poll();
            }

            // add the resultant array
            result[i-k+1] = maxHeap.peek()[0];
        }
        return result;
    }
}
