package restart.gemini.dynamicprogramming;

public class TrappedRainWater {

    public static void main(String[] args) {
        int [] heights = {7,4,0,9};
        System.out.println(trappedRainWater(heights));
    }

    static int trappedRainWater (int [] heights) {
        int totalWater = 0;
        int n = heights.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];

        leftMax[0] = heights[0];
        for (int i=1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],heights[i]);
        }

        rightMax[n-1] = heights[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], heights[i]);
        }

        for (int i=0; i < n; i++) {
            totalWater += Math.min(leftMax[i],rightMax[i])-heights[i];
        }

        return totalWater;
    }

}
