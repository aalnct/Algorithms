package restart.array.intermidiate;

import java.util.Arrays;
import java.util.List;

public class MaximumDistanceArray {

    public static void main(String[] args) {
        List<List<Integer>> array = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7)
        );
        System.out.println(maxDistanceArray(array));
    }
    // array is in sorted in ascending order
    static int maxDistanceArray (List<List<Integer>> arrays) {
        int minValue = arrays.get(0).get(0); // first element
        int maxValue = arrays.get(0).get(arrays.get(0).size()-1); // last element

        int maxDistance = 0;

        for (int i=1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size()-1);

            maxDistance = Math.max(maxDistance, Math.abs(minValue - currentMax));
            maxDistance = Math.max(maxDistance, Math.abs(maxValue - currentMin));

            // update current min and current max values
            minValue = Math.min(minValue,currentMin);
            maxValue = Math.max(maxValue,currentMax);
        }
        return maxDistance;
    }
}