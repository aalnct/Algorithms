package restart.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int [] temperature = new int[] {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperature(temperature))); // output should be | 1 | 1 | 1 | 0 |
    }

    static int [] dailyTemperature ( int [] temperature) {
        int n = temperature.length;
        Stack<Integer> helperStack = new Stack<>();
        int [] result = new int[n];

        for (int i= n-1; i >=0; i--) {
            while (!helperStack.isEmpty() && temperature[i] >= temperature[helperStack.peek()]) {
                helperStack.pop();
            }

            // if I reach here that means that index at top of stack has more value  than current element
            if (!helperStack.isEmpty()) {
                result[i] = helperStack.peek() - i;  // will store the difference b/w value in stack and current stack
            }

            helperStack.push(i);
        }
        return result;
    }
}
