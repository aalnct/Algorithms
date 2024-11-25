package restart.array;

import java.util.PriorityQueue;

public class KLargestElement {


    public static void main(String[] args) {
        int [] array = {3, 5, 7, 2, 8, -1, 4, 10, 12};
        System.out.println("Max : " + kthLargestElement(array,6));
    }

    private static int kthLargestElement (int [] arrays, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int array : arrays) {
            priorityQueue.add(array);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
