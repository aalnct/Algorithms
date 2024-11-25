package restart.gemini.dynamicprogramming;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater(heights));
    }

    static int containerWithMostWater (int [] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;

        while (left < right) {
            int containerHeight = Math.min(heights[left], heights[right]);
            int width = right - left;

            int currentArea = containerHeight * width;

            maxArea = Math.max(maxArea,currentArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }

}
