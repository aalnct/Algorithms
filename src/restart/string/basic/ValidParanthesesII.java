package restart.string.basic;

import java.util.Stack;

public class ValidParanthesesII {

    public static void main(String[] args) {
        String string = "({})";
        System.out.println(isValid(string));
    }

    static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        char [] charArr = s.toCharArray();

        for (int i=0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') {
                stack.push(charArr[i]);
        } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if ( (charArr[i] == ')' && top != '(')
                        || (charArr[i] == '}' && top != '{')
                        || (charArr[i] == ']') && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
