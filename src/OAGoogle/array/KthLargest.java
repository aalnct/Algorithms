package OAGoogle.array;

import java.util.PriorityQueue;

public class KthLargest {


    public static void main(String[] args) {
        int [] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        int k = 3;

        System.out.println(kthLargest(nums,k));
    }

    static int kthLargest (int [] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); // this is to custom compare the natural ordering of elements ...

        for (int n : nums) {
            pq.add(n);
        }

        int result = 0;
        for (int i=0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }
}
