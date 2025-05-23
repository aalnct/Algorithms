package OAGoogle.array;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.println(Arrays.toString(reverseArray(numbers,k)));
    }

    static int [] reverseArray (int [] numbers, int k) {
        int n = numbers.length;
        k = k % n; // when k is bigger than n

        reverse(numbers, 0, n-1);
        reverse(numbers, 0, k-1);
        reverse(numbers, k, n-1);

        return numbers;
    }

    static void reverse (int [] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }
}
