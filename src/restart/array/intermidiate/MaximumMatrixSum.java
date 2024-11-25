package restart.array.intermidiate;

public class MaximumMatrixSum {

    public static void main(String[] args) {
        int [][] grid = {
                {1,2,3},
                {-1,-2,-3},
                {1,2,3}
        };

        System.out.println(maxMatrixSum(grid));
    }

    static int maxMatrixSum (int [][] grid) {
        int totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;


        int n = grid.length;

        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                int value = grid[i][j];

                totalSum += Math.abs(value);

                if (value < 0) {
                    negativeCount++;
                }

                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 == 0) {
            return totalSum;
        } else return totalSum - 2 * (minAbsValue);
    }
}
