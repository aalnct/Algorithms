package OAGoogle.queues;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 1
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 2

        queue.enqueue(4);
        System.out.println("Size: " + queue.size()); // Should print 2
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 3
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 4

    }

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueWithTwoStacks () {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue () {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
