package Sorting;

import java.util.Stack;

public class MinRemovalForVaild {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public static String minRemoveToMakeValid (String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if  (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*'); // marking unmatched closing paranthesis
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replaceAll("\\*" , "");
    }
}
