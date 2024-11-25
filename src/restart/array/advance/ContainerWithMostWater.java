package restart.array.advance;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater(height));
    }

    static int containerWithMostWater (int [] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while (left < right) {
            int containerHeight = Math.min(height[left], height[right]);
            int width = right - left;

            int currentArea = containerHeight * width;

            maxArea = Math.max(maxArea,currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
