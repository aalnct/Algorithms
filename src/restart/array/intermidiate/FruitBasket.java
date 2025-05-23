package restart.array.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    public static void main(String[] args) {
        int [] fruits= {1, 2, 1, 2, 3, 2, 2};
        System.out.println(maxFruitCount(fruits));
    }

    /**
     * Sliding window approach
     */

    static int maxFruitCount (int [] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;

        Map<Integer,Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right],0) + 1);

            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit)-1);

                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
