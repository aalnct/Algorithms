package learingcontinue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingLeaderboard {

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100,90,90,80);
        List<Integer> player = Arrays.asList(70,80,105);

        climbingLeaderBoard(ranked,player).forEach(System.out::println);
    }


    static List<Integer> climbingLeaderBoard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>();
        List<Integer> uniqueRanks = getUniqueRank(ranked);
        int n = uniqueRanks.size();
        int m = player.size();
        int i = n-1;

        for (int score : player) {
            while (i >0 && score >= uniqueRanks.get(i)) {
                i--;
            }

            if (i == -1) {
                ranks.add(1);
            } else if (score == uniqueRanks.get(i)) {
                ranks.add(i+1);
            } else {
                ranks.add(i+2);
            }
        }
        return ranks;
    }


    private static List<Integer> getUniqueRank (List<Integer> ranked) {
        List<Integer> uniqueRanked = new ArrayList<>();
        uniqueRanked.add(ranked.get(0));

        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i-1))) {
                uniqueRanked.add(ranked.get(i));
            }
        }

        return uniqueRanked;
    }
}
