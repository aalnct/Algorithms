package fb;

public class MaximumAscendingSum {

    public static void main(String[] args) {
        int[] array = {10,20,30,5,5,10,50};
        int i  = maxAscendingSum(array);
        System.out.println(i);
    }

    static int maxAscendingSum (int[] array) {
        int highest = 0;
        for (int i=0; i < array.length; i++) {
            int current = array[i];

            for (int k = i+1; k < array.length; k++) {
                if (array[k-1] >= array[k] ) {
                    break;
                } else if (array[k-1] < array[k] ) {
                    current += array[i];
                }
            }

            highest = current > highest ? current : highest;
        }

        return highest;
    }
}
