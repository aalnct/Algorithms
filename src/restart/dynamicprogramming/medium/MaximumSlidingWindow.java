package restart.dynamicprogramming.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    // we keep sliding the window and will only
    // have k elements visible at a time
    // and select the max out of those k elements and store it in array
    static int [] maxSlidingWindow (int [] nums, int k) {
        int n = nums.length;
        int [] dp = new int [n-k+1];

        // since we are using max heap, larger element on top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((a,b) -> b[0] - a[0]));

        // first k elements
        for (int i=0; i < k; i++) {
            maxHeap.offer(new int [] {nums[i],i});
        }

        if (maxHeap.peek() != null) {
            dp[0] = maxHeap.peek()[0];
        }
        // add remaining elements
        for (int i= k; i < n; i++) {
            maxHeap.offer(new int [] {nums[i],i});
            // check if window is going out of bounds (i.e. k)
            while (maxHeap.peek() != null && maxHeap.peek()[1] <= (i-k)) {
                maxHeap.poll();
            }
            if (maxHeap.peek() != null) {
                dp[i-k+1] = maxHeap.peek()[0];
            }
        }
        return dp;
    }
}
