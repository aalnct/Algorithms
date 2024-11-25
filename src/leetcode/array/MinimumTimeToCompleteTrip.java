package leetcode.array;

import java.util.Arrays;

public class MinimumTimeToCompleteTrip {

    public static void main(String[] args) {
        int[] time = {1,2,3};
        int totalTrips = 5;

        System.out.println(minimumTime(time,totalTrips));
    }

    private static long minimumTime(int [] time, int totalTrips) {
        int n = time.length;
        int [] minTimes = new int[n];

        Arrays.fill(minTimes,Integer.MAX_VALUE);
        minTimes[0] = 0; // first node will be starting at 0

        for (int trips = 0; trips < totalTrips; trips++) {
            int[] newMinTimes = new int[n];
            Arrays.fill(newMinTimes, Integer.MAX_VALUE);

            for (int i=0; i < n; i++) {
                for (int j=0; j < n; j++){
                    if (i != j) { // not travelling to itself
                        int travelTime = time[i] + time[j];
                        newMinTimes[j] = Math.min(
                                newMinTimes[j], travelTime + minTimes[i]
                        );
                    }
                }
            }
            minTimes = newMinTimes;
        }

        return minTimes[n-1];
    }
}
