package OAOracle;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("amit"));
    }

    static String reverseString (String reverse) {
        StringBuilder newReverseString = new StringBuilder();
        char [] charArray = reverse.toCharArray();

        for ( int i =charArray.length-1; i >= 0 ; i--) {
            newReverseString.append(charArray[i]);
        }
        return newReverseString.toString();
    }
}
