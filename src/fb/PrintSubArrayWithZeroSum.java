package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubArrayWithZeroSum {

    public static void main(String[] args) {
        int [] array = new int[] { 4, 2, -3, -1, 0, 4 }; //
        List<List<Integer>> list = printSubArrayWithZeroSum(array);
        list.stream().forEach(System.out::println);
        // printSubArray(array);
    }

    static List<List<Integer>> printSubArrayWithZeroSum (int [] array) {
        List<Integer> list = null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);

        int start = 0;
        int end = array.length-1;

        for (int i = start; i<array.length; i++) {
            list = new ArrayList<>();
            if (array[start] + array[end] == 0) {
                list.add(array[start]);
                list.add(array[end]);

                result.add(list);

            }
            else if (array[start] + array[end] < 0) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }


    static void printSubArray(int[] array) {
        for (int i =0;i < array.length; i++) {
            int sum = 0;

            for (int j = i; j <array.length; j++) {
                sum += array[j];

                if (sum == 0) {
                    System.out.println("SubArray " +i + " " +  j);
                }
            }
        }
    }
}
