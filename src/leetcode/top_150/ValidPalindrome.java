package leetcode.top_150;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(input));
    }

    private static boolean isValidPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while(left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            while(left < right &&
            !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input
                    .charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
