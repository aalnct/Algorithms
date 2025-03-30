package neetcode150.twopointer;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input = "Was it a car or a cat I saw?";
        System.out.println(isValidAlphaNumericPalindrome(input));
    }

    static boolean isValidAlphaNumericPalindrome (String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
