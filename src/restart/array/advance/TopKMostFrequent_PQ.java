package restart.array.advance;

import java.util.*;

public class TopKMostFrequent_PQ {

    public static void main(String[] args) {
        int [] array = {1,1,1,2,2,3};
        int topK = 2;
        System.out.println(Arrays.toString(topKMostFrequent(array,topK)));
    }

    // return order does not matter
    static int [] topKMostFrequent (int [] nums, int topK) {
        // Step 1 Create Frequency Map
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n,0) + 1);
        }

        // Step 2 Use Min Heap to keep track of top K elements
        // using comparator to make sure heap is ordered by the frequency of elements
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        // Step 3 Keeping Heap size to K
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > topK) {
                minHeap.poll();
            }
        }

        // Step 4 Extract Elements from Heap
        int [] result = new int[topK];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }
        return result;
    }
}
