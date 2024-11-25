package restart.dynamicprogramming.hard;

public class TrappingRainWater_2 {

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater(height));
    }

    static int trappingRainWater (int [] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;

        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        int totalWater = 0;

        leftMax[0] = 0;
        for (int i=1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for (int i=n-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i=0; i <n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }
}