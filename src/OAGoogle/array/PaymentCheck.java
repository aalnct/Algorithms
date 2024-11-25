package OAGoogle.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentCheck {

    public static void main(String[] args) {
        int[] timestamps_1 = {1, 4, 5, 10, 11, 14};
        int[][] payments_1 = {{1, 2}, {25, 65}, {25, 65}, {1, 2}, {25,65}, {1, 2}};
        int timelimit_1 = 5;

        List<String> result = paymentCheck(timelimit_1,payments_1,timestamps_1);

        result.stream().forEach(System.out::println);
    }

    static List<String> paymentCheck (int timeLimit, int [][] payments, int [] timestamps) {
        List<String> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<payments.length; i++) {
            int sender = payments[i][0];
            int receiver = payments[i][1];
            int timestamp = timestamps[i];

            if (map.containsKey(receiver) &&
            timestamp - map.get(receiver) <= timeLimit) {
                result.add("true");
            } else {
                result.add("false");
            }

            map.put(receiver,timestamp);
        }
        return result;
    }
}
