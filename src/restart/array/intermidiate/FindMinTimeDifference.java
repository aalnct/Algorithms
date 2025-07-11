package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinTimeDifference {

    public static void main(String[] args) {
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        System.out.println(findMinTimeDifference(timePoints1));
        System.out.println(minTimeDifferenceSortingAndAdjacentComparison(timePoints1));
    }

    static int findMinTimeDifference (List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            minutes.add(timeToMinutes(time));
        }
        int minDiff = Integer.MAX_VALUE;

        for (int i=0; i <minutes.size(); i++) {
            for (int j = i+1; j < minutes.size(); j++) {
                int time1 = minutes.get(i);
                int time2 = minutes.get(j);

                int diff = Math.abs(time1 - time2);
                int circularDiff = Math.min(diff, 1440-diff);

                minDiff = Math.min(minDiff,circularDiff);

                if (minDiff == 0) {
                    return 0;
                }
            }
        }
        return minDiff;
    }

    static int timeToMinutes (String time) {
        String [] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        return hours * 60 + minutes;
    }


    static int minTimeDifferenceSortingAndAdjacentComparison (List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            minutes.add(timeToMinutes(time));  // o(n)
        }

        Collections.sort(minutes); // o (n log n)

        int minDiff = Integer.MAX_VALUE;

        for (int i= 1; i < minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i - 1);
            minDiff = Math.min(minDiff, diff);

            if (minDiff == 0) {
                return 0;
            }
        }
            int wrapAround = 1440 - (minutes.get(minutes.size()-1) - minutes.get(0));
            minDiff = Math.min(minDiff,wrapAround);

            return minDiff;
        }
}
