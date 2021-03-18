package fb;

import java.util.Arrays;

public class SubArrayZeroSum {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }; // -7,-4,-2,-2,1,1,3,3,3,4
        boolean check = subArrayZeroSum(array);
        System.out.println(check);
    }

    static boolean subArrayZeroSum (int [] array) {
        boolean check = false;
        int start = 0; // -7
        int end = array.length-1; // 4
        // O(nlogn)
        Arrays.sort(array);
        for (int i = start;i<array.length;i++) {
            if (array[start] + array[end] == 0) {
                check = true;
            } else if (array[start] + array[end] < 0) {
                start++;
            } else {
                end--;
            }
        }

        return check;
    }



}
