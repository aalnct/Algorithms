package ds.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParantheeses {

    private static String balancedParantheeses = "{[(])}";
    private static Deque<Character> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        boolean result = checkBalance(balancedParantheeses);
        if (result) {
            System.out.println("Balanced");
        }else {
            System.out.println("Not Balanced");
        }
    }

    private static boolean checkBalance (String balancedParantheeses) {

            for (int i=0; i<balancedParantheeses.length();i++) {
                char x = balancedParantheeses.charAt(i);
                if (x == '(' || x == '{' || x == '[') {
                    deque.push(x);
                    continue;
                }

                if (deque.isEmpty()) {
                    return false;
                }
                char check;
                switch (x) {
                    case ')' :
                     check = deque.pop();
                     if (check == '{' || check == '[') {
                         return false;
                     }
                     break;
                    case '}' :
                     check = deque.pop();
                     if (check == '(' || check == '[') {
                         return false;
                     }
                        break;
                    case ']' :
                     check = deque.pop();
                     if (check == '{' || check == '(') {
                         return false;
                     }
                        break;
                }
            }
            return deque.isEmpty();
    }
}
