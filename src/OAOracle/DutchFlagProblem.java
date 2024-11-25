package OAOracle;

public class DutchFlagProblem {

    public static void main(String[] args) {
        int [] nums = {0,2,1,0,1,2,2,0};
        int[] n = dutchFlagProblem(nums);

        for (int r : n) {
            System.out.println(r);
        }
    }

    static int [] dutchFlagProblem (int [] nums) {
        // merge sort
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid < high) {
            if (nums[mid] == 0) {
                swap(nums,low,mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // means == 2
                swap(nums,mid,high);
                high--;
            }
        }

        return nums;
    }

    private static void swap (int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
