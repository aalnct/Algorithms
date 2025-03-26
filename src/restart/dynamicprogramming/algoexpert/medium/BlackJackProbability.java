package restart.dynamicprogramming.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class BlackJackProbability {

    public static void main(String[] args) {
        int target = 21;
        int startingHand = 10;
        System.out.println("Target " + target + " starting hand " + startingHand);
        System.out.println("Bust Probability : " + updateCalculation(blackJackProbability(startingHand, target)));
    }

    static float blackJackProbability (int starting, int target) {

        if (starting >= target - 4) {
            return starting > target ? 1 : 0;
        }
        Map<Integer,Float> memo = new HashMap<>();
        return calculateProbability(starting,target,memo);
    }

    static float calculateProbability (int currentSum, int target, Map<Integer,Float> memo) {
        if (currentSum > target) {
            return 1;
        }

        if (currentSum >= target - 4) {
            return 0;
        }

        if (memo.containsKey(currentSum)) {
            return memo.get(currentSum);
        }

        float probability = 0;

        for (int card = 1; card <= 10; card++) {
            probability += 0.1 * calculateProbability(currentSum+card,target,memo);
        }
        memo.put(currentSum,probability);

        return probability;
    }

    static String updateCalculation (double probability) {
        probability = Math.round(probability * 1000) / 1000.0;
        return String.format("%.3f", probability);
    }
}
