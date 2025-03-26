package restart.string.intermidiate;

import java.util.Stack;

public class MinimumRemovalParantheses {
    public static void main(String[] args) {
        String string = "a)b(c)d";
        System.out.println(minimumRemoval(string));
    }

    static String minimumRemoval (String string) {
        StringBuilder sb = new StringBuilder(string);
        Stack<Character> stack = new Stack<>();

        for (int i=0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c ==')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(),'*');
        }

        return sb.toString().replaceAll("\\*", "");
    }
}
