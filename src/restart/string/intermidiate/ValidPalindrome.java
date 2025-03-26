package restart.string.intermidiate;

/**
 * Check if string is valid palindrome for alpha-numeric character ...
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String text = "race e car";
        System.out.println(isValidPalindrome(text));
    }

    static boolean isValidPalindrome(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        // Creating two pointers which will move right/left
        int left = 0;
        int right = text.length()-1;

        text = text.toLowerCase();

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
