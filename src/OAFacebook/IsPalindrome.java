package OAFacebook;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    static boolean isPalindrome(String string) {
        String result = string.replaceAll("[^a-zA-Z0-9]", "");

        char [] newString = result.toLowerCase().toCharArray();

        int left = 0;
        int right = newString.length-1;

        while (right >=0 ) {
            if (newString[left] != newString[right]) {
                return false;
            }
            left++;
            right--;
        }

        System.out.println("Original :" + string);
        System.out.println("New String :" + result);

        return true;
    }
}
