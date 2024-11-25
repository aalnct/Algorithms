package OAFacebook;

public class OneEditDistance {

    public static void main(String[] args) {
        System.out.println(oneEditDistance_2("ab", "acb"));
    }

    static boolean oneEditDistance (String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m > n) {
            return oneEditDistance(t,s); // to make sure t is greater than s (in length)
        }

        if (n-m > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        int editCount = 0;

        while ( i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                editCount++;
                if (editCount > 1) {
                    return false;
                }
                if (m == n) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }

        if (m < n) {
            editCount++; // a single character insertion is allowed at this point ?
        }

        return editCount == 1;
    }


    static boolean oneEditDistance_2 (String s, String t) {
        if (s.length() == t.length()) {
            int numDifference = 0;
            for (int i=0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    numDifference++;
                }
            }

            return numDifference == 1;
        }
        else {
            int longerString = Math.max(s.length(),t.length());
            int shorterString = Math.min(s.length(),t.length());

            if (longerString - shorterString > 1) {
                return false;
            }

            // find the index of the character that is different or -1
            int differentIndex = -1;
            for (int i=0; i < shorterString; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    differentIndex = i;
                    break;
                }
            }
            return differentIndex >= 0 &&
                    (s.length() ==  longerString && s.charAt(differentIndex) == t.charAt(differentIndex+1)
                    || (t.length() == longerString && t.charAt(differentIndex) == s.charAt(differentIndex-1)));
        }
    }
}
