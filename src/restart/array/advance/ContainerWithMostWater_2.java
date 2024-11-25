package restart.array.advance;

public class ContainerWithMostWater_2 {

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxContainer(height));
    }


    static int maxContainer (int [] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int containerHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;

            int currentArea = currentWidth * containerHeight;

            maxArea = Math.max(currentArea,maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
