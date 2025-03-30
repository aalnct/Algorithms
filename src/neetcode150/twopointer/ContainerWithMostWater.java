package neetcode150.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {1,7,2,5,4,7,3,6};
        System.out.println(maxArea(height));
    }

    static int maxArea (int [] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left) ;

            maxArea = Math.max(maxArea,area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
