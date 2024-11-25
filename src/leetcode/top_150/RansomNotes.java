package leetcode.top_150;

public class RansomNotes {
    public static void main(String[] args) {
        String ransomNotes = "aa";
        String magazine = "aab";
        System.out.println(ransomNotes(ransomNotes,magazine));
        System.out.println(canConstruct(ransomNotes,magazine));
    }

    private static boolean ransomNotes(String ransomNotes, String magazine) {
        int [] magazineCount = new int[26];

        for (char ch : magazine.toCharArray()) {
            magazineCount[ch - 'a']++;
        }

        for (char ch : ransomNotes.toCharArray()) {
            if (magazineCount[ch - 'a'] -- <= 0) {
                return false;
            }
            magazineCount[ch - 'a']--;
        }
        return true;
    }

    private static boolean canConstruct (String ransom, String magazine) {
        int [] ransomCount = new int[26];
        int [] magazineCount = new int[26];

        for (char ch : ransom.toCharArray()) {
            ransomCount[ch - 'a']++;
        }

        for (char ch : magazine.toCharArray()) {
            magazineCount[ch - 'a']++;
        }

        for (int i=0; i < 26; i++) {
            if(ransomCount[i] > magazineCount[i]) {
                return false;
            }
        }
        return true;
    }
}
