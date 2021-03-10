package fb;

public class StringReverseWord {

    public static void main(String[] args) {
        String s = reverseWord("HELLO");
        System.out.println(s);
    }

    static String reverseWord (String string) {
        char[] c = string.toCharArray();
        int start = 0;
        int end = c.length-1;

        while (start < end) {
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;

            start++;
            end--;
        }

        string = String.valueOf(c);

        return string;
    }
}
