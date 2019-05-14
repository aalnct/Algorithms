package ds.dequeue;

import java.util.*;

/**
 * Created by AmitAgarwal on 3/19/19.
 */
public class QueueDS {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        System.out.println("Enter N");
        int n = scanner.nextInt();

        System.out.println("Enter M");
        int m = scanner.nextInt();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            System.out.println("Iterating ....");
            int input = scanner.nextInt();

            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }

        }
            System.out.println(max);

    }
}
