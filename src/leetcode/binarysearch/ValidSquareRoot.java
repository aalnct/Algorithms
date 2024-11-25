package leetcode.binarysearch;

public class ValidSquareRoot {

    public static void main(String[] args) {
        System.out.println(validSquareRoot(19));
    }

    private static  boolean validSquareRoot (int number) {

        long left = 1;
        long right = number;
        while (left <= right) {
            long mid = left + (right - left)/2;
            long square = mid * mid;

            if (square == number) {
                return true;
            } else if (square > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
