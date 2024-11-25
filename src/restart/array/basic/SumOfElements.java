package restart.array.basic;

import java.util.Arrays;

public class SumOfElements {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        System.out.println(sumOfElements(array));
    }

    static int sumOfElements (int [] array) {
        int sum = 0;
        for (int i =0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

}
