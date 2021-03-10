package fb;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] array = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] resultArray = topKFrequentElements(array,k);

        for (int ii : resultArray) System.out.println(ii);
    }

    static int[] topKFrequentElements(int [] array, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<array.length;i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i] , 1);
            }else {
                map.put(array[i] , map.get(array[i])+1);
            }
        }

        for (int i=0;i<array.length;i++) {
            if (map.get(array[i]) >= k && !set.contains(array[i])) {
                set.add(array[i]);
            }
        }

        // resultArray = Arrays.copyOf(set.toArray(), set.size(), Integer[].class);

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}
