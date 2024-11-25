package restart.gemini.dynamicprogramming;

public class HouseRobber {

    public static void main(String[] args) {
        int [] house = {1,2,3,1};
        System.out.println(houseRobber(house));
    }

    static int houseRobber (int [] house) {
        int [] dp = new int[house.length];

        if (house.length < 2) {
            return house[0];
        }

        dp[0] = house[0];
        dp[1] = Math.max(house[0], house[1]);

        for (int i=2; i < house.length; i++) {
            dp[i] = Math.max(dp[0] + house[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
