package restart.dynamicprogramming.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {

    public static void main(String[] args) {
        int maxChooseable = 20;
        int desired = 152;

        System.out.println(canIWin(maxChooseable,desired));
    }

    static boolean canIWin (int maxChooseable, int desired) {

        if (maxChooseable >= desired) {
            return true;
        }

        int totalSum = maxChooseable * (maxChooseable+1)/2;

        if (totalSum < desired) {
            return false;
        }

        Map<String ,Boolean> memo = new HashMap<>();
        boolean [] used = new boolean[maxChooseable+1];

        return canWin(maxChooseable,desired,used,memo);
    }

    static boolean canWin (int maxChooseable, int desired, boolean [] used, Map<String,Boolean> memo) {
        String key = Arrays.toString(used);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i=1; i <= maxChooseable; i++) {
            if (!used[i]) {
                if (i >= desired) {
                    memo.put(key, true);
                    return true;
                }

                // else have to try this move
                used[i] = true;
                boolean opponentWin = canWin(maxChooseable,desired-i,used,memo);
                used[i] = false; // backtracking

                if (!opponentWin) {
                    memo.put(key,true);
                    return true;
                }
            }
        }
        memo.put(key,false);
        return false;
    }
}
