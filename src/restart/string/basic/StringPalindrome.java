package restart.string.basic;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("hello"));
    }

    static boolean isPalindrome (String text) {

        char [] ch = text.toCharArray();


        int start = 0;
        int end = ch.length-1;
        text.charAt(start);
        while (start < end) {
            if (ch[start] != ch[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}