package neetcode150.binary.search;

public class KokoEatingBanana {

    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        System.out.println(minEatingSpeed(piles,8));
    }

    static int minEatingSpeed (int [] piles, int hours) {
        int maxSpeed = 0;

        for (int pile : piles) {
            maxSpeed = Math.max(pile, maxSpeed);
        }

        int left = 1;
        int right = maxSpeed;

        while (left < right) {
            int mid = left + (right-left)/2;

            int hourseNeeded = 0;

            for (int pile : piles) {
                hourseNeeded += (pile + mid - 1)/mid;
            }

            if (hourseNeeded <= hours) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
