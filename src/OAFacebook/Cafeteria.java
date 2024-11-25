package OAFacebook;

import java.util.Arrays;

public class Cafeteria {

    public static void main(String[] args) {
        long N = 10;
        long M = 2;
        long K = 1;
        long[] S = {2,6};
        long result = maxAdditionalDiners(N, M, K, S);

        System.out.println("Maximum additional diners: " + result);
    }

    static long maxAdditionalDiners(long n, long m, long k, long [] s) {
        Arrays.sort(s);

        long maxAdditionalDiner = 0;

        for (int i=0; i < m-1; i++) {
            long emptySeatsLeft = (s[i]-1)/(2 * k+1);
            long emptySeatsRight = (s[i+1] - s[i]-1)/(2 * k+1);
            long maxBetweenDiners = (emptySeatsRight + emptySeatsLeft);

            maxAdditionalDiner = Math.max(maxAdditionalDiner,maxBetweenDiners);
        }

        long emptySeatsLeft = (s[0]-1)/(2*k+1);
        long emptySeatsRight = (n - s[(int) (m-1)])/(2*k+1);

        long maxAdditionalDinersLeft = emptySeatsLeft;
        long maxAdditionalDinersRight =  emptySeatsRight;

        // calculate overall max additional diners
        long maxAdditionalDinersOverAll = Math.max(Math.max(maxAdditionalDinersLeft,
                        maxAdditionalDinersRight), maxAdditionalDiner);

        return maxAdditionalDinersOverAll;
    }
}
