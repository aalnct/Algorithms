package leetcode.top_150;

public class ValidAnagram {

    public static void main(String[] args) {
        String sText = "anagram";
        String tText = "nagaram";

        System.out.println(isValidAnagram(sText,tText));
    }


    private static boolean isValidAnagram (String sText, String tText) {
        if (sText.length() != tText.length()) {
            return false;
        }

        int [] sCount = new int[26];
        int [] tCount = new int[26];

        for (char ch : sText.toCharArray()) {
            sCount[ch - 'a']++;
        }

        for (char ch : tText.toCharArray()) {
            tCount[ch- 'a']++;
        }

        for (int i=0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }

        return true;
    }
}
