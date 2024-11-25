package leetcode.binarysearch;

public class MySqrt {
    public static void main(String[] args) {
        int number = 4;
        System.out.println(mySQRT(number));
    }

    private static int mySQRT (int number) {
        int left = 1;
        int right = number;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int square = mid * mid;

            if (square == number) {
                return mid;
            } else if (square < number) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid -1;
            }
        }
        return result;
    }
}
