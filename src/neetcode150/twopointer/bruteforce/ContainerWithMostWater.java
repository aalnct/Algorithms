package neetcode150.twopointer.bruteforce;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] height = {1,7,2,5,4,7,3,6};
        System.out.println(maxArea(height));
    }

    static int maxArea(int [] height ) {
        int maxArea  = 0;

        // run two loops,
        // i and j , where j = i+1

        for (int i=0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}