package restart.array.intermidiate;

public class EatingBanana {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int H = 8;

        int result = minBananaEating(piles, H);
        System.out.println(result);
    }

    private static int minBananaEating ( int [] piles, int h) {
        int min = 1;
        int max = getMax(piles);

        while (min < max) {
            int mid = min + (max - min)/2;
            if (canFinishEating (piles, h, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private static boolean canFinishEating ( int [] piles , int h, int k) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + k -1)/k;
        }
        return hour <= h;
    }

    private static int getMax ( int [] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max,pile);
        }
        return max;
    }
}
