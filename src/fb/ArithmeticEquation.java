package fb;

import java.util.Stack;

public class ArithmeticEquation {

    public static void main(String[] args) {
        String s = "4*3+2";
        int output = solveArithmeticEquation(s);
        System.out.println(output);
    }

    static int solveArithmeticEquation (String s) {
        char[] tokens = s.toCharArray();
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i< tokens.length; i++) {
            // whitespace skip it
            if (tokens[i] == ' ') {
                continue;
            }

            // current token is a number, push it to number stack
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sb = new StringBuffer();

                // there may be more than one digits in a number

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                    numberStack.push(Integer.parseInt(sb.toString()));

                    // right now i point to character next to digit,
                    // since the for loop also increase the i, so we need to
                    // fix the offset
                }
                    i--;
            }
            // current token is open braces, push it to operator stack
            else if (tokens[i] == '(') {
                operatorStack.push(tokens[i]);
            }

            // closing braces encountered, solve the equation
            else if (tokens[i] == ')') {
                while (operatorStack.peek() != '(') {
                    numberStack.push(applyOps(operatorStack.pop(), numberStack.pop(), numberStack.pop()));
                    operatorStack.pop();
                }
            }

            // current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '*') {
                // while top of operator stack has same or greater precendence to current token, which is an operator
                // apply operator on top of operator stack, to top two elements in number stack
                while (!operatorStack.empty() &&
                        hasPrecedence(tokens[i],
                                operatorStack.peek()))
                    numberStack.push(applyOps(operatorStack.pop(),
                            numberStack.pop(),
                            numberStack.pop())); {
                    operatorStack.push(tokens[i]);
                }
            }

            // entire expression has been parsed at this point, apply remaining operators to remaining values

            while (!operatorStack.isEmpty()) {
                numberStack.push(applyOps(operatorStack.pop(), numberStack.pop(), numberStack.pop()));
            }

        }
        return numberStack.pop();
    }

    static boolean hasPrecedence (char op1, char op2) {
        if (op1 == '(' || op2 == ')') {
            return false;
        }
        if (op1 == '*' && op2 == '+') {
            return false;
        } else return true;
    }

    static int applyOps (char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '*':
                return a * b;
        }
        return 0;
    }
}