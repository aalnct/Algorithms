package neetcode150.twopointer;

public class TrappedRainWater {

    public static void main(String[] args) {
        int [] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappedRainWater(height));
    }

    static int trappedRainWater (int [] height) {
        int water = 0;

        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
