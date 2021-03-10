package ds.leetcode;

public class MaximumWealth {
    public static void main(String[] args) {
        int[][] account = new int [][] {
                {1,2},
                {3,9},
                {10,11}
        };

        int max = maximumWealth(account);
        System.out.println(max);
    }

    private static int maximumWealth (int[][] accounts) {
        int max = 0;

        for (int i=0; i< accounts.length; i++) {
            int tempMax = 0;

            for (int j=0; j < accounts[i].length;j++) {
                tempMax += accounts[i][j];
            }
            max = Math.max(max,tempMax);
        }
        return max;
    }
}
