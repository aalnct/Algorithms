package ds.leetcode.StringSolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by AmitAgarwal on 6/22/20.
 */
public class MatchingParanthesis {

    public static void main(String[] args) {
        boolean flag = isValid("[{()}]");
        System.out.println(flag);
    }

    public static boolean isValid(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('{' , '}');
        map.put('[' , ']');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length();i++){
            char current = s.charAt(i);
            if(map.containsKey(current)){
                stack.push(current);
            }else if(map.containsValue(current)){
                if(!stack.isEmpty() && map.get(stack.peek()) == current){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
