package stackds;

import java.util.Stack;

/**
 * Created by AmitAgarwal on 5/5/20.
 */
public class MaxOperationStack {

    private static Stack<Integer> stack;
    private static Stack<Integer> maxStack;

    private MaxOperationStack(){
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    private static void push(int x){
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    private static int pop(){
        maxStack.pop();
        return stack.pop();
    }

    private static int top(){
        return stack.peek();
    }

    private static int peekMax(){
        return maxStack.peek();
    }

    private static int popMax(){
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(top() != max) buffer.push(pop());
        pop();
        while(!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        int result = popMax();
        System.out.println(result);
    }
}
