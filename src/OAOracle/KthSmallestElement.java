package OAOracle;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main (String [] args) {
        int [] nums = {3, 1, 4, -1, 5, 9, 2, 6};
        System.out.println(kthSmallest(nums,5));
    }

    static int kthSmallest (int [] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
        }

        int result = 0;
        for (int i=0; i < k; i++) {
            result = pq.poll();
        }
        return result;
    }
}
