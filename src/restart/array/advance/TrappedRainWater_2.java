package restart.array.advance;

public class TrappedRainWater_2 {

    public static void main(String[] args) {
        int [] height = {7 ,4 ,0 ,9};
        System.out.println(trappedRainWater(height));
    }

    static int trappedRainWater(int [] height) {
        int totalWater = 0;

        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];

        leftMax[0] = height[0];
        // calculate max from left
        for (int i=1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        // calculate right max
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // calculate trapped water
        for (int i=0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}
