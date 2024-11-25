package restart.array.advance;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int [] array = {1, 2, 3, -2, 5};
        System.out.println(maxSubArray(array));
    }

    static int maxSubArray (int [] array) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("Array cannot be null or empty");
        }

        int maxCurrent = array[0];
        int maxGlobal = array[0];

        for (int i= 1; i < array.length; i++) {
            maxCurrent = Math.max(array[i], maxCurrent + array[i]);
            if (maxGlobal < maxCurrent) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }
}
