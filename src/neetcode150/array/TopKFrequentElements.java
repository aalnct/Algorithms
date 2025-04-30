package neetcode150.array;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequentElements(nums,k)));
    }

    // time complexity : O(n log k)
    static int [] topKFrequentElements (int [] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // keep the min at top
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent element
            }
        }

        int [] result = new int[k];
        for (int i=k-1; i>=0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}
