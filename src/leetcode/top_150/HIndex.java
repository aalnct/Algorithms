package leetcode.top_150;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int [] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }

    private static int hIndex(int [] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int hIndex = 0;

        for (int i=0; i < length; i++) {
            int h = Math.min(citations[i] , length - i);
            hIndex = Math.max(h,hIndex);
        }
        return hIndex;
    }
}
