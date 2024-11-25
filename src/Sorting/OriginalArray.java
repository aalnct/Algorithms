package Sorting;

import java.util.*;

public class OriginalArray {

    public static void main(String[] args) {
        int[] nums = {6, 3, 0, 1};
        // System.out.println(Arrays.toString(findOriginal_2(nums)));
        System.out.println(Arrays.toString(findOriginalArray(nums)));
        System.out.println(Arrays.toString(findOriginalArray_3(nums)));
        System.out.println(Arrays.toString(findOriginalArray_4(nums)));
    }


    private static int[] findOriginal(int[] nums) {
        int n = nums.length;
        int[] original = new int[n]; // one more array (original values) with half of size

        for (int i = 0; i < n; i++) {
            int doubleValue = nums[i] + nums[i];
            while (i < nums.length) {
                if (doubleValue == nums[i]) {
                    System.out.println(i);
                    original[i] = nums[i];
                }
                i++;
            }
            // i = 0;
        }
        return original;
    }

    private static int[] findOriginal_2(int[] nums) {
        int[] original = new int[nums.length / 2];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i + 1]) {
                original[count++] = nums[i];
            }
        }
        return original;
    }

    // interesting approach to solve the problem using Map
    private static int[] findOriginalArray(int[] doubledArray) {
        // check if the length of the doubled array is even
        if (doubledArray.length % 2 != 0) {
            return new int[0]; // invalid input, return empty array
        }

        // use hashmap to store the element occurrences frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // count the frequency of each element
        for (int num : doubledArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // sort the double array in ascending order
        Arrays.sort(doubledArray);

        // iterate over the sorted doubled array
        int[] originalArray = new int[doubledArray.length / 2];
        int index = 0;

        for (int num : doubledArray) {
            if (frequencyMap.containsKey(num)
                    && frequencyMap.containsKey(num * 2)) {
                originalArray[index++] = num;

                // decrement the frequence
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                frequencyMap.put(num * 2, frequencyMap.get(num * 2) - 1);

                // remove the entry once frequence becomes 0

                if (frequencyMap.get(num) == 0) {
                    frequencyMap.remove(num);
                }

                if (frequencyMap.get(num * 2) == 0) {
                    frequencyMap.remove(num * 2);
                }
            }
        }
        // check if all elements are found
        if (index != originalArray.length) {
            return new int[0];

        }
        return originalArray;
    }


    public static int[] findOriginalArray_3(int[] doubledArray) {
        int n = doubledArray.length;

        // Check if the length of the doubled array is odd
        if (n % 2 != 0) {
            return new int[0]; // Invalid input, return an empty array
        }

        // Create a HashMap to store the frequency of each element in the doubled array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the doubled array
        for (int num : doubledArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Sort the doubled array in ascending order
        Arrays.sort(doubledArray);

        // Iterate over the sorted doubled array
        List<Integer> originalList = new ArrayList<>();
        for (int num : doubledArray) {
            if (frequencyMap.containsKey(num) && frequencyMap.containsKey(num * 2)) {
                originalList.add(num);
                // Decrement the frequencies of num and num * 2 in the HashMap
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                frequencyMap.put(num * 2, frequencyMap.get(num * 2) - 1);
                // Remove the entry from the HashMap if the frequency becomes 0
                if (frequencyMap.get(num) == 0) {
                    frequencyMap.remove(num);
                }
                if (frequencyMap.get(num * 2) == 0) {
                    frequencyMap.remove(num * 2);
                }
            }
        }

        // Check if all elements have been found in the original array
        if (originalList.size() != n / 2) {
            return new int[0]; // Invalid input, return an empty array
        }

        // Convert the ArrayList to an array
        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }

        return originalArray;
    }

    private static int[] findOriginalArray_4(int[] changed) {
        if (changed.length % 2 !=0) {
            return new int[0];
        }

        // sort
        Arrays.sort(changed);

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int num : changed) {
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0) + 1);
        }

        int [] original = new int[changed.length/2];
        int count = 0;

        for (int num : changed) { // {6, 3, 0, 1} -- > {0,1,3,6}
            // if element exists
            if (frequencyMap.get(num) > 0) {
                frequencyMap.put(num,frequencyMap.get(num)-1);
                int twice = num * 2;

                if (frequencyMap.containsKey(twice) && frequencyMap.get(twice) > 0) {
                    // pair up the element , decrement the count
                    frequencyMap.put(twice,frequencyMap.get(twice)-1);
                    original[count++] = num;
                } else {
                    return new int[0];
                }
            }
        }
        return original;
    }
}
