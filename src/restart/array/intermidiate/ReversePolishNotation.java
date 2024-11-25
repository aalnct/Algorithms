package restart.array.intermidiate;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String [] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(reversePolishNotation(tokens));
    }

    static int reversePolishNotation ( String [] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" :
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(b + a);
                    break;
                case "-" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default :
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
