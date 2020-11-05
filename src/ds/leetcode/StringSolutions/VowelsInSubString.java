package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 6/30/20.
 */
public class VowelsInSubString {

    public static void main(String[] args) {

    }

    public static int containsVowels(String str, int k){
        // k - length of substring
        if(str == null || str.length() == 0){
            return 0;
        }
        int currentVowels = 0;
        int count = 0;
        if(str.length() < k){
            return 0;
        }
        for(int i=0; i< k ;i++){
            if(isVowel(str.charAt(i))){
                currentVowels++;
                count = Math.max(currentVowels,count);
            }
        }
        for(int i=k; i< str.length();i++){
            if(isVowel(str.charAt(i-k))) currentVowels--;
            if(isVowel(str.charAt(i))) currentVowels++;

            count = Math.max(currentVowels,count);
        }
        return count;
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
