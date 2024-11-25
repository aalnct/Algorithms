package restart.array.advance;

import java.util.*;

public class TopKElements_2 {

    public static void main(String[] args) {
        int [] array = {1,1,1,2,2,3};
        int topK = 2;
        System.out.println(Arrays.toString(topKElements(array,topK)));
    }

    static int [] topKElements (int [] array, int topK) {
        // Step 1 Frequency Map

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int a : array) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a,0) + 1);
        }

        // step 2 Now we need a list of type array that will store element frequency as index and element

        List<Integer> [] bucket = new List[array.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            // initialize the bucket
            bucket[i] = new ArrayList<>();
        }

        // Step 3 Now iterate frequency map to get the elements and their frequency
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            int numKey = entry.getKey();
            int numValue = entry.getValue();

            bucket[numValue].add(numKey); // example bucket [3] = 1 means element 1 appears 3 times
        }

        // Step 4 collect top K elements from the bucket
        List<Integer> topKElements = new ArrayList<>();

        for (int i = bucket.length-1; i >= 0 && topKElements.size() < topK; i--) {
            if (!bucket[i].isEmpty()) {
                topKElements.addAll(bucket[i]);
            }
        }

        // Step 5 convert List into an array
        int [] result = new int[topK];
        for (int i =0; i < topK; i++) {
            result[i] = topKElements.get(i);
        }

        return result;
    }
}
