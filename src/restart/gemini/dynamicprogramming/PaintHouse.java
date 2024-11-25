package restart.gemini.dynamicprogramming;

public class PaintHouse {

    public static void main(String[] args) {
        int [][] costs = {
                {17,2,17},
                {16,16,5},
                {14,3,19}
        };

        System.out.println(minCostToPaintHouse(costs));
    }

    static int minCostToPaintHouse (int [][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n  = costs.length;

        for (int i=1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }

}
