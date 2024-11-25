package restart.gemini.dynamicprogramming;

public class HouseRobber2 {

    /**
     * Houses are built in circular shape and cannot rob two adjacent houses
     */

    public static void main(String[] args) {
        int [] house = {2,3,2};
        System.out.println(houseRobber_2(house));
    }

    static int houseRobber_2 (int [] house) {
        if (house.length < 2) {
            return house[0];
        }

        // either skip first house
        // or skip last house

        int [] skipFirstHouse = new int[house.length-1];
        int [] skipLastHouse = new int[house.length-1]; // since we are going to skip one of the house


        for (int i=0; i < house.length-1; i++) {
            skipFirstHouse[i] = house[i+1];
            skipLastHouse[i] = house[i];
        }

        int skippingFirstHouse = helperHouseRobber(skipFirstHouse);
        int skippingLastHouse = helperHouseRobber(skipLastHouse);

        return Math.max(skippingFirstHouse,skippingLastHouse);
    }

    static int helperHouseRobber (int [] house) {
        if (house.length < 2) {
            return house[0];
        }

        int [] dp = new int[house.length];

        dp[0] = house[0];
        dp[1] = Math.max(house[0],house[1]);

        for (int i=2; i < house.length; i++) {
            dp[i] = Math.max(dp[0] + house[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
