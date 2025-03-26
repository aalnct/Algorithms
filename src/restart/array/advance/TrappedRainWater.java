package restart.array.advance;

public class TrappedRainWater {

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappedRainWater(height));
    }

    static int trappedRainWater (int [] height) {

        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft  =height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
