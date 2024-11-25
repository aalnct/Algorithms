package Sorting;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMissing(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMissing(Character open, char close) {
        return (open == '(' && close == ')'
                   || (open == '[' && close == ']')
                       || (open == '{' && close == '}'));
    }
}
