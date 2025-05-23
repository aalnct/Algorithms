package OAGoogle.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParenthesis(n));
    }

    static List<String> generateParenthesis (int  n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0,0,n);
        return  result;
    }

    static void backtrack (List<String> result, String current, int open , int close, int max) {

        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current+'(', open+1, close, max);
        }

        if (close < open) {
            backtrack(result, current+')', open, close+1, max);
        }
    }
}
