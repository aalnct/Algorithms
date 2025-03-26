package restart.array.advance;

import java.util.PriorityQueue;

public class StringRepeatWithLimit {

    public static void main(String[] args) {
        String s = "cczazcc";
        int limit = 3;

        System.out.println(repeatLimit(s,limit));
    }

    static String repeatLimit (String s, int limit) {
        int [] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++; // COUNTING FREQUENCY FOR EVERY CHARACTER
        }


        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for (int i=0;i < 26; i++) {
            if (frequency[i] > 0) { // CHECKING EACH CHARACTER OCCURRENCE IN FREQUENCY ARRAY
                maxHeap.offer((char) (i + 'a')); // IF MORE THAN 0, ADD THEM TO HEAP
            }
        }


        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();

            int count = Math.min(frequency[current - 'a'] , limit);

            for (int i=0; i < count; i++) {
                sb.append(current);
            }

            frequency[current -'a'] -=count;

            if (frequency[current - 'a'] > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }

                char next = maxHeap.poll();
                sb.append(next);
                frequency[next - 'a']--;

                if (frequency[next - 'a'] > 0) {
                    maxHeap.offer(next);
                }

                maxHeap.offer(current);
            }
        }

        return sb.toString();
    }
}
