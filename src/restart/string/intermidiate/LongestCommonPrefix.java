package restart.string.intermidiate;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String [] array = {"Flower", "Fluke", "Flow"};
        System.out.println(longestCommonPrefix(array));
    }

    static String longestCommonPrefix (String [] array) {
        if (array == null || array.length == 0) {
            return "";
        }

        Arrays.sort(array); // O(nlogn)

        int i = 0;

        String first = array[0];
        String last = array[array.length - 1];

        while (i < first.length() && i < last.length()
        && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0,i);
    }
}
