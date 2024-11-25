package restart.dynamicprogramming.medium;

public class OneEditDistance {

    public static void main(String[] args) {
        String s = "ab";
        String t = "acb";

        System.out.println(" first test case " + isOneEditDistance(s,t));

        s = "adb";
        t = "ad";

        System.out.println(" Second test case " + isOneEditDistance(s,t));
    }

    static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (m > n) {
            return isOneEditDistance(t, s);
        }

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    // check remaining from position of mismatch
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return (m + 1 == n);
    }
}