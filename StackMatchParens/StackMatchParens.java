package com.loonycorn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jananiravi on 11/25/15.
 */
public class StackMatchParens {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public static void main(String[] args) {
        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", hasMatchingParens("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));
    }

    public static boolean hasMatchingParens(String input) {

        try {
            Stack<Character> parenStack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                // Add to the stack for an opening paren.
                if (openingParenSet.contains(ch)) {
                    parenStack.push(ch);
                }
                if (matchingParenMap.containsKey(ch)) {
                    Character lastParen = parenStack.pop();
                    if (lastParen != matchingParenMap.get(ch)) {
                        return false;
                    }
                }
            }

            return parenStack.isEmpty();
        } catch (Stack.StackOverflowException soe) {
            System.err.println("Stack Overflow");
        } catch (Stack.StackUnderflowException sue) {
            System.err.println("Stack Underflow");
        }

        return false;
    }

}
