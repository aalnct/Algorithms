package OAOracle;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(10);
        stackUsingQueues.push(20);
        stackUsingQueues.push(30);

        System.out.println("Top Element ::" + stackUsingQueues.top());
        System.out.println("Popped Element :: " + stackUsingQueues.pop());
        System.out.println("Is Stack Empty ::" + stackUsingQueues.isEmpty());
    }

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty!!");
        }
        int poppedElement;

        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i=0; i < size-1; i++) {
                queue2.offer(queue1.poll());
            }
            poppedElement = queue1.poll();
        } else {
            int size = queue2.size();
            for (int i=0; i < size-1; i++) {
                queue1.offer(queue2.poll());
            }
            poppedElement = queue2.poll();
        }
        return poppedElement;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }

        int topElement = 0;

        if (!queue1.isEmpty()) {
            int size = queue1.size();

            for (int i=0; i < size; i++) {
                topElement = queue1.poll();
                queue2.offer(topElement);
            }
        } else {
            int size = queue2.size();
            for (int i=0; i < size; i++) {
                topElement = queue2.poll();
                queue1.offer(topElement);
            }
        }
        return topElement;
    }

    public boolean isEmpty() {
        return !queue1.isEmpty() && !queue2.isEmpty();
    }

}
