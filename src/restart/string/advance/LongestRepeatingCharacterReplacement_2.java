package restart.string.advance;

public class LongestRepeatingCharacterReplacement_2 {

    public static void main(String[] args) {
        String text = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(text,k));
    }

    private static int characterReplacement (String text, int k) {
        int maxLength = 0;
        int left = 0;
        int maxCount = 0;
        int [] charCount = new int[26]; // maximum alphabets

        for (int right = 0; right < text.length(); right++) {
            charCount[text.charAt(right) - 'A']++;
            int count = charCount[text.charAt(right) - 'A'];
            maxCount = Math.max(maxCount, count);
            // when current window becomes invalid, increment left, to reduce window size
            while (right - left + 1 - maxCount > k) {
                charCount[text.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }
}
