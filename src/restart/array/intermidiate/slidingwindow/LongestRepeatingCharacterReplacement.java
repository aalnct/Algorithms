package restart.array.intermidiate.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s,k));
    }

    static int characterReplacement (String s, int k) {
        int [] count = new int[26];
        int maxCount = 0; // any character max frequency
        int maxLength = 0; // keep track of maxSubstring length
        int left = 0; // this will use to shorten the window if window length and max frequency becomes greater than k

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar - 'A']++;

            maxCount = Math.max(maxCount,count[rightChar-'A']);

            while ((right - left + 1)  - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}