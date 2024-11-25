package restart.string.advance;

public class TakeCharacters {

    public static void main(String[] args) {
        String string = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(string,k));
    }

    static int takeCharacters (String string, int k) {
        int n = string.length();
        int [] count = new int[3];

        for (char c : string.toCharArray()) {
            count[c-'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        int left = 0;
        int maxValidWindow = 0;
        int [] windowCount = new int[3];

        for (int right = 0; right < n ; right++) {
            windowCount[string.charAt(right) - 'a']++; // writing to current window character count

            while (windowCount[0] > count[0] - k || windowCount[1] > count[1] - k || windowCount[2] > count[2] - k) {
                // now we will shrink the window
                windowCount[string.charAt(left) - 'a']--;
                left++;
            }

            maxValidWindow = Math.max(maxValidWindow, right - left + 1);
        }

        return n - maxValidWindow;
    }

}
