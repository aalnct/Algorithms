package restart.array.basic;

public class MaximumArray {

    public static void main(String[] args) {
        int [] array = {3, 5, 13, 2, 8, -1, 4, 10, 12};
        System.out.println(" Max element in an array " + maximum(array));
    }

    private static int maximum (int [] array) {
        int max = array[0];

        for (int i=0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
