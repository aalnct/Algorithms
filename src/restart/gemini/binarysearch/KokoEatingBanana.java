package restart.gemini.binarysearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        System.out.println(kokoEatingBanana(piles,8));
    }

    // h total hours
    static int kokoEatingBanana (int [] piles, int h) {

        int low = 1; // at least this much koko can eat
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = (low + high)/2;

            if (canFinish(piles, mid, h)) {
                high = mid; // reduce speed
            } else {
                low = mid + 1; // increase speed
            }
        }

        return low;
    }

    static boolean canFinish (int [] piles, int k, int h) {
        int hoursNeeded = 0;

        for (int pile : piles) {
            hoursNeeded += (pile + k -1)/k;
        }

        return hoursNeeded <= h;
    }

}
