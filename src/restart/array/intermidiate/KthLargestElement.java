package restart.array.intermidiate;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;

        // expected output is 5
        System.out.println(kthlargestElement(nums,k));
    }

    // using max heap approach first

    private static int kthlargestElement (int [] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>();

        for (int i=0; i < nums.length; i++ ) {
            maxheap.offer(nums[i]);

            if (maxheap.size() > k) {
                maxheap.poll(); // within loop keep removing the elements if heap isze is more than k
            }
        }

        return maxheap != null ? maxheap.peek() : null;
    }
}
