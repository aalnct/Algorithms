package restart.string.intermidiate;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String string = ")(";
        System.out.println(validParenthesis(string));
        string = "(*)";
        System.out.println(validParenthesis(string));
    }

    static boolean validParenthesis(String string) {
        int low = 0;
        int high = 0;

        for (int i=0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else if (c == '*') {
                low--;
                high++;
            }

            low = Math.max(0,low);

            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}
