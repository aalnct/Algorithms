package restart.string.intermidiate;

public class SubStringOccurance {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(subString(haystack,needle));
    }

    static int subString (String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        // check of each index till the length of needle if it is matching
        for (int i=0; i < haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
