package Sorting;

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        int [] expected = new int [] {1,1,4,2,1,3};
        // System.out.println(Arrays.toString(heightChecker(expected)));


        System.out.println(heightChecker_2(expected));
    }

    public static int[] heightChecker(int [] expected) {
        boolean isDone = true;
        while (isDone) {
            isDone = false;
            for (int i = 0; i < expected.length-1; i++) {
                if (expected[i] > expected[i+1]) {
                    int temp = expected[i+1];
                    expected[i+1] = expected[i];
                    expected[i] = temp;
                    isDone = true;
                }
            }
        }
        return expected;
    }


    public static int heightChecker_2 (int [] height) {
        int [] expected = height.clone(); // create a new array with same properties
        Arrays.sort(expected); // need to sort it so that we can compare the expected with given
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] != expected[i]) {
                count++; // so that we can record the count of how many elements are at the same position
            }
        }
        return count;
    }
}
