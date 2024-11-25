package OAFacebook;

import java.util.*;

public class ArrayIntersectionWithFrequency {

    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(arrayIntersection(nums1,nums2)));
    }

    static int[] arrayIntersection(int [] nums1, int [] nums2) {
        Map<Integer,Integer> countMap1 = new HashMap<>();
        Map<Integer,Integer> countMap2 = new HashMap<>();

        for (int n : nums1) {
            countMap1.put(n, countMap1.getOrDefault(n,0)+1);
        }

        for (int n : nums2) {
            countMap2.put(n, countMap2.getOrDefault(n,0)+1);
        }

        List<Integer> intersection = new ArrayList<>();

        // find the common elements with their frequencies
        for (Map.Entry<Integer,Integer> entry : countMap1.entrySet()) {
            int num = entry.getKey();
            int count1 = entry.getValue();
            int count2 = countMap2.getOrDefault(num,0);

            int minCount = Math.min(count1,count2);

            for (int i=0; i < minCount; i++) {
                intersection.add(num);
            }
        }

        int [] resultArray = new int[intersection.size()];
        for (int i=0; i < intersection.size(); i++) {
            resultArray[i] = intersection.get(i);
        }

        return resultArray;
    }
}
