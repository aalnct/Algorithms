package fb;

public class QuickSort_3 {

    public static void main(String[] args) {
        int[] array = new int[] {5,2,3,1};
        sortArray(array);

        for (int i: array) {
            System.out.println(i);
        }
    }

    public static int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        quickSort(nums, start, end);

        return nums;
    }

    private static void quickSort (int[] nums, int start, int end) {
        if (start <= end) {
            int pp = getPartitionPoint(nums, start, end);
            quickSort(nums,start,pp-1);
            quickSort(nums,pp+1,end);
        }
    }

    private static int getPartitionPoint(int[] nums, int start, int end) {
        int j = start-1; // -1
        int pivot = nums[end];
        for (int i=start; i < end;i++) {
            if (nums[i] <= pivot) {
                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = nums[j+1];
        nums[j+1] = nums[end];
        nums[end] = temp;
        return j+1;
    }
}
