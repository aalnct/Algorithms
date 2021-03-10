package fb;

import java.util.HashSet;
import java.util.Set;

public class StringHalvesAlikew {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }

    static boolean halvesAreAlike (String str) {

        int mid = str.length()/2;
        int vowelCounterleft = 0;
        int vowelCounterRight = 0;

        for (int i=0;i <  mid; i++) {

            if (isVowelLetter(str.charAt(i))) {
                vowelCounterleft ++;
            }

            if (isVowelLetter(str.charAt(mid + i))) {
                vowelCounterRight++;
            }
        }

        return vowelCounterleft == vowelCounterRight;
    }

    private static boolean isVowelLetter (char c) {
        char left = Character.toLowerCase(c);

        return left == 'a' || left == 'e' ||
                left == 'i' || left == 'o' || left == 'u';
    }
}
