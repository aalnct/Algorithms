package restart.dynamicprogramming.medium;

public class PainHouse2 {

    public static void main(String[] args) {
        int [][] cost  = {
                {1, 5, 3}, {2, 9, 4}
        };

        System.out.println(housePaint(cost));
    }


    static int housePaint ( int [][] cost) {
        if (cost == null || cost.length == 0) {return 0;}

        int n = cost.length; // total houses
        int k = cost[0].length; // total colors


        int min1 = -1;
        int min2 = -1; // if cost of painting current house index matches min1, take min2

        for (int i=0; i < n; i++) {
            int lastMin1 = min1;
            int lastMin2 = min2;

            min1 = -1;
            min2 = -1;

            for (int j=0; j<k; j++) {

                if (i > 0) { // i index should be greater than 0 for comparison

                    if (j == lastMin1) {
                        cost[i][j] += (lastMin2 == -1 ? 0 : cost[i-1][lastMin2]);
                    } else {
                        cost[i][j] += (lastMin1 == -1 ? 0 : cost[i-1][lastMin1]);
                    }

                }

                // update the min1 and min2 for current house
                if (min1 == -1 || cost[i][j] < cost[i][min1]) {
                    min2 = min1;
                    min1 = j; // 0
                } else if (min2 == -1 || cost[i][j] < cost[i][min2]) {
                    min2 = j;
                }
            }
        }
        return cost[n-1][min1]; // final answer is the minimum cost to paint the last house
    }

}
