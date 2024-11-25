package leetcode.top_150;

public class ReverseString {

    public static void main(String[] args) {
        String text = "the sky is blue";
        System.out.println(reverseString(text));
        System.out.println(reverseString_2(text));

        char[] c = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};

        System.out.println(reverseWords(c));

    }

    static String reverseString (String text) {
        char [] charArray = text.toCharArray();
        int left = 0;
        int right = text.length()-1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    static String reverseString_2(String text) {
        char [] charArray = text.toCharArray();
        int start = 0;

        for (int end =0; end < charArray.length; end++) {
            if (charArray[end] == ' ') {
                reverse(charArray,start,end-1);
                start = end + 1;
            }
        }
        // reverse the last word
        reverse(charArray,start,charArray.length-1);

        // reverse the entire string
        reverse(charArray,0,charArray.length-1);

        return new String(charArray);
    }

    static void reverse (char [] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }
    }

    static String reverseWords (char [] text) {
        reverse(text, 0, text.length-1);

        int start = 0;

        for (int end = 0; end < text.length; end++) {
            if (text[end] == ' ') {
                reverse(text, start,end-1);
                start = end + 1;
            }
        }

        // reverse the last word
        reverse(text,start,text.length-1);

        return new String(text);
    }
}
