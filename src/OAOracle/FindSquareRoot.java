package OAOracle;

public class FindSquareRoot {

    public static void main(String[] args) {
        int number = 2147395599;
        System.out.println(findSquareRoot(number));
    }

    static int findSquareRoot (int number) {
        long left = 1;
        long right = number;
        int result = 0;

        while (left <= right) {
            long mid = left + (right - left)/2;
            long square = mid * mid;

            if (square == number) {
                return (int)mid;
            } else if (square < number) {
                left = mid + 1;
                result = (int) mid; // store the potential result
            } else {
                right = mid-1;
            }
        }
        return result;
    }
}
