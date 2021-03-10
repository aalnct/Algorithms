package fb;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int target = 9;
        List<Integer>  result = twoSum(array,target);

        for (int ii : result) {
            System.out.print(ii + " ");
        }

        int[] array1 = {5,6,3,8,11,0,9,2};
        target = 11;
        // System.out.println(twoSumWithMultiplePairs(array1,target));

        System.out.println("");

        List<Integer> ll = slidingWindowSolution(array1,target);

        for(int l : ll) {
            System.out.println(l);
        }
    }

    static List<Integer> twoSum(int[] array, int target) {
        List<Integer> list = new ArrayList<>();
        if (array.length<=0) {
            return list;
        }

        int i = 0; // start of array
        int j = array.length-1; // end of array

        while(i<j) {
            if (array[i] + array[j] == target) {
                list.add(i);
                list.add(j);
                return list;
            } else if (array[i] + array[j] < target) {
                i++;
            } else  {
                j--;
            }
        }

        return list;
    }

    static int twoSumWithMultiplePairs(int array[], int target) {
        Map<Integer,Integer> map = new HashMap<>();
        // first iterator
        for(int i=0;i<array.length;i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i])+1);
            }
        }
        int counter = 0;
        for (int i=0;i<array.length;i++) {
            if (map.get(target-array[i]) != null) {
                counter += map.get(target-array[i]);
            }

            if (target - array[i] == array[i]) {
                counter--;
            }
        }
        return counter/2;
    }

    public static List<Integer> slidingWindowSolution(int [] array, int target) {
        Arrays.sort(array);
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = array.length-1;

        for (int i=0;i<array.length;i++) {
            if (array[start] + array[end] == target) {
                list.add(start);
                list.add(end);
                start++;
            } else if (array[start] + array[end] < target)  {
                start++;
            } else {
                end--;
            }
        }
        return list;
    }
}
