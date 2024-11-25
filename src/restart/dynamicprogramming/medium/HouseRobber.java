package restart.dynamicprogramming.medium;

// Dynamic Programming
public class HouseRobber {

    public static void main(String[] args) {
        int [] house = {1,2,3,1};
        System.out.println(robHouse(house));
    }

    static int robHouse(int [] house) {
        if (house.length < 2) {
            return house[0];
        }

        int [] dp = new int[house.length];

        dp [0] = house[0];
        dp[1] = Math.max(house[0],house[1]);

        for (int i=2; i < house.length; i++) {
            // use below formula to arrive at solution
            dp[i] = Math.max(dp[i-2] + house[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }

}
