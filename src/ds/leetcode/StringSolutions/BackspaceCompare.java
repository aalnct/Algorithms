package ds.leetcode.StringSolutions;

import java.util.Stack;

/**
 * Created by AmitAgarwal on 6/18/20.
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        boolean flag = backspaceCompare(S,T);
        System.out.println(flag);
    }

    public static boolean backspaceCompare(String S, String T){
        return build(S).equals(build(T));
    }


    private static String build(String S){ // only one  parameter is enough
        Stack<Character> stack = new Stack();
        for(char c : S.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

}
