package OAGoogle.binarysearch;

public class NumberGuessing {

    static int number = 9;

    public static void main(String[] args) {
        System.out.println(guessNumber(8));
    }

    static int guess (int n) {
        if (n == number) {
            return 0;
        } else if (n > number) {
            return -1;
        } else if (n <number) {
            return 1;
        }
        return 0;
    }
    static int guessNumber (int number) {

        int start = 0;
        int end = number;

        while (start <= end) {
            int pivot = start + (end - start)/2;
            int guess = guess(pivot);

            if (guess == 0) {
                return pivot;
            } else if (guess < 0) {
                end = pivot -1;
            } else if (guess > 0) {
                start = pivot + 1;
            }
        }
        return -1;
    }
}
