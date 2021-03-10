package fb;

import java.util.Arrays;

// also called as string anagram
public class StringPermutation {

    public static void main(String[] args) {
        boolean validation = stringPermutation("abc", "dba");
        System.out.println(validation ? " is permutation" : "is not permutation");
    }

    static boolean stringPermutation(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2) {
            return false;
        }

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i=0; i< ch1.length;i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
