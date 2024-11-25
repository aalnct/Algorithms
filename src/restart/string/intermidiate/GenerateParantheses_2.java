package restart.string.intermidiate;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses_2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParanthesis(n));
    }

    // using backtracking
    static List<String> generateParanthesis (int n) {
        List<String> result = new ArrayList<>();
        backTracking(result,"",0,0,n);
        return result;
    }

    static void backTracking (List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backTracking(result,current + "(", open+1, close,max);
        }
        if (close < open) {
            backTracking(result,current + ")", open,close + 1, max);
        }
    }

}
