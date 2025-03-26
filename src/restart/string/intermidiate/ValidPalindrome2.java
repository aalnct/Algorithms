package restart.string.intermidiate;

public class ValidPalindrome2 {

    public static void main(String[] args) {
        String text = "abcx";
        System.out.println(isValidPalindrome(text));
    }

    static boolean isValidPalindrome (String text) {
        // remove at most one character and check if string is palindrome
        // using two pointer approach
        if (text == null || text.length() == 0) {
            return true;
        }

        int left = 0;
        int right = text.length()-1;

        while (left < right) {
            if (text.charAt(left) == text.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindromeCheck(text,left+1,right) || isPalindromeCheck(text,left, right-1);
            }
        }
        return true;
    }

    // this method either skip character from left
    // or skip from right
    static boolean isPalindromeCheck (String text, int left, int right) {
        while (left < right) {
            if (text.charAt(left) == text.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
