package OAGoogle.array;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int [] numbers = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentElements(numbers,2)));
    }

    static int [] topKFrequentElements (int [] numbers, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int n : numbers) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(frequencyMap::get)
        );

        for (int n : frequencyMap.keySet()) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll(); // it will remove the elements with least frequency
            }
        }

        int [] res = new int [k];
        for (int i = k-1; i >=0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}
