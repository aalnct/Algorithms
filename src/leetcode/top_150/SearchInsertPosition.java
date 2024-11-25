package leetcode.top_150;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int [] array = {1,3,5,6};
        int target = 7;

        System.out.println(searchInsertPosition(array,target));
    }

    private static int searchInsertPosition(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while (left <= right) {
            int pivot = left + (right - left)/2;

            if (array[pivot] == target) {
                return pivot;
            } else if (array[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left;
    }
}
