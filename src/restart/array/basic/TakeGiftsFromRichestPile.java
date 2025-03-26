package restart.array.basic;

import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {

    public static void main(String[] args) {
        int [] gifts = {
                25, 64, 9, 4, 100
        };
        int k =4;

        System.out.println(giftPiles(gifts,k));
    }

    static long giftPiles (int [] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i=0; i < k; i ++) {
            int currentMax = maxHeap.poll();

            int remaining = (int) Math.sqrt(currentMax);

            maxHeap.offer(remaining);
        }

        long total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }
        return total;
    }

}
