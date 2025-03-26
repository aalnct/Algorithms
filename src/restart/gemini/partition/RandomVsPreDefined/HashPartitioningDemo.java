package restart.gemini.partition.RandomVsPreDefined;

import java.util.HashMap;
import java.util.Map;

/**
 * this is to demonstrate how randomly defined or Predefined partition works
 */
public class HashPartitioningDemo {

    public static void main(String[] args) {

        String [] keys = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

        int numberOfPartitions = 4;

        System.out.println(" **** Random Partition **** ");
        Map<Integer,StringBuilder> randomPartition = randomHashBasedPartition(keys,numberOfPartitions);
        printPartitions(randomPartition);

        System.out.println(" **** PreDefined Partitions **** ");
        int [] preDefinedBoundaries = {0x0000, 0x4000, 0x8000, 0xC000};
        Map<Integer,StringBuilder> preDefinedPartition = preDefinedPartition(keys,preDefinedBoundaries);
        printPartitions(preDefinedPartition);
    }

    static Map<Integer,StringBuilder> randomHashBasedPartition (String [] keys, int numberOfPartitions) {
        Map<Integer,StringBuilder> partitions = new HashMap<>();
        for (int i=0; i < numberOfPartitions; i++) {
            partitions.put(i, new StringBuilder());
        }

        for (String key : keys) {
            int hash = key.hashCode();
            int partition = Math.abs(hash % numberOfPartitions);
            partitions.get(partition).append(key).append(" ");
        }
        return partitions;
    }

    static Map<Integer,StringBuilder> preDefinedPartition (String [] keys, int [] preDefinedPartitions) {
        Map<Integer,StringBuilder> partitions = new HashMap<>();

        for (int i=0; i < preDefinedPartitions.length; i++) {
            partitions.put(i, new StringBuilder());
        }

        for (String key : keys) {
            int hash = key.hashCode();
            int partition = findPartitionByBoundary(Math.abs(hash), preDefinedPartitions);
            partitions.get(partition).append(key).append(" ");
        }
        return partitions;
    }

    static int findPartitionByBoundary (int hash, int [] preDefinedPartitions) {
        for (int i=0; i < preDefinedPartitions.length-1; i++) {
            if (hash >= preDefinedPartitions[i] && hash < preDefinedPartitions[i+1]) {
                return i;
            }
        }
        return preDefinedPartitions.length-1; // hash value greater than the largest boundary
    }

    static void printPartitions (Map<Integer,StringBuilder> partitions) {
        for (Map.Entry<Integer,StringBuilder> entry : partitions.entrySet()) {
            System.out.println(" partition " + entry.getKey() + " " + entry.getValue());
        }
    }
}