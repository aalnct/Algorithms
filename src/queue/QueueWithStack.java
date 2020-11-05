package queue;

import java.util.Stack;

/**
 * Created by AmitAgarwal on 5/5/20.
 */
public class QueueWithStack {

    /**
     * First create two stack variables
     */

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    private static void enQueue(int x){
        /**
         * Push everything from stack1 to stack2 if stack1 is not empty
         */
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);

        /**
         * Push everything back to stack1
         */

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private static int deQueue(){
        // first check if stack is empty
        if(stack1.isEmpty()){
            System.out.println("Q is empty");
            System.exit(0);
        }
        // return top of s1
        int x = stack1.peek();
        stack1.pop();
        return x;
    }

    public static void main(String[] args) {
        QueueWithStack q = new QueueWithStack();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println("Dequue Operations 1:" + q.deQueue());
        System.out.println("Dequue Operations 2:" + q.deQueue());
        System.out.println("Dequue Operations 3:" + q.deQueue());
    }
}
