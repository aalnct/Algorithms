package restart.array.advance;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        int [] array = {1,1,1,2,2,3};
        int topK = 2;

        System.out.println(Arrays.toString(topKFrequencyElements(array,topK)));
    }

    static int [] topKFrequencyElements (int [] array, int topK) {
        // Frequency map
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int a : array) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a,0) + 1);
        }

        // Step 2 is to create a list of array to store element by their frequency
        List<Integer> [] bucket = new List[array.length + 1];

        for (int i=0; i < bucket.length; i ++) {
            bucket[i] = new ArrayList<>();
        }

        // populate bucket with element frequency
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            bucket[freq].add(num);
        }

        // collect top k elements from bucket

        List<Integer> topKElements = new ArrayList<>();

        for (int i=bucket.length-1; i >= 0 && topKElements.size() < topK; i--) {
            if (!bucket[i].isEmpty()) {
                topKElements.addAll(bucket[i]);
            }
        }

        // convert list into array
        int [] result = new int[topK];
        for (int i=0; i < topK; i++) {
            result[i] = topKElements.get(i);
        }

        return result;

    }
}
