package fb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BalancedString {
    public static void main(String[] args) {
        boolean passed = isBalanced("{[(])}");
        if (passed) {
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }
    }

    private static boolean isBalanced (String s) {
        if (s == null || s.length() == 0 ) return true;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char match;
            switch (c) {
                case ')' :
                    match = stack.pop();
                    if (match == '{' || match == '[') {
                        return false;
                    }
                    break;
                case '}':
                    match = stack.pop();
                    if (match == '(' || match == '(') {
                        return false;
                    }
                    break;
                case ']' :
                    match = stack.pop();
                    if (match == '(' || match == '{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
