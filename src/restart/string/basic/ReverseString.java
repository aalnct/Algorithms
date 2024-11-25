package restart.string.basic;

public class ReverseString {

    public static void main(String[] args) {
        String text = "Hello";
        System.out.println(reverseString(text));
    }

    static String reverseString (String text) {
        char [] charArray = text.toCharArray();

        int left = 0;
        int right = charArray.length-1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}
