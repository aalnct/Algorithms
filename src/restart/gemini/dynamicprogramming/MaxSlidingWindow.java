package restart.gemini.dynamicprogramming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int [] array = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(array,3)));
    }

    static int [] maxSlidingWindow (int [] array, int k) {
        int n = array.length;

        int [] result = new int[n-k+1]; // we only need that many elements to store

        PriorityQueue<int []> maxheap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for (int i=0; i < k; i++) {
            maxheap.offer(new int [] {array[i], i});
        }

        assert maxheap.peek() != null;
        result[0] = maxheap.peek()[0];

        for (int i=k; i < n; i++) {
            maxheap.offer(new int[] {array[i],i});

            while (true) {
                assert maxheap.peek() != null;
                if (!(maxheap.peek()[1] <= i-k)) break;
                maxheap.poll();
            }

            result[i-k+1] = maxheap.peek()[0];
        }

        return result;

    }

}
