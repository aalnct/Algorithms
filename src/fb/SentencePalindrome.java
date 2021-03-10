package fb;

public class SentencePalindrome {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str) ? "Palindrome" : "not palindrome");
    }

    private static boolean isPalindrome (String str) {

        int start = 0;
        int end = str.length() -1;

        str = str.toLowerCase();

        for (int i = 0;i < str.length(); i++) {
            while (start <= end) {
                char getStart = str.charAt(start);
                char getEnd = str.charAt(end);

                // validation of the characters
                if (!(getStart >= 'a' && getStart <= 'z')) {
                    start++;
                }
               else if (!(getEnd >= 'a' && getEnd <= 'z')) {
                    end--;
                }

                else if (getStart == getEnd) {
                    start++;
                    end--;
                }else return false;
            }
        }
        return true;
    }
}
