package restart.gemini.partition;

import java.util.HashMap;
import java.util.Map;

public class HashBasedPartition {

    public static void main(String[] args) {
        int [] keys = {1,2,3,4,5,6,7,8,9,10};

        int numberOfPartitions = 4;

        Map<Integer, StringBuilder> map = new HashMap<>();

        for (int i=0; i < numberOfPartitions; i++) {
            map.put(i, new StringBuilder());
        }

        // hash based partition
        for (int key : keys) {
            // this wil generate the partition index i can say

            int partition = key % numberOfPartitions;

            // adding key to corresponding partition
            // here I am adding data to that key/index
            map.get(partition).append(key).append(" ");
        }

        for (int i=0; i < numberOfPartitions; i++) {
            System.out.println("Partition " + i + " : " + map.get(i).toString().trim());
        }
    }

}
