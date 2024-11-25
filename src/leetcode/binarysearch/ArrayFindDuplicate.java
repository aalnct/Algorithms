package leetcode.binarysearch;

public class ArrayFindDuplicate {

    public static void main(String[] args) {
        int [] duplicate = {1,3,4,2,2};
        System.out.println(findDuplicate(duplicate));
    }

    private static int findDuplicate(int [] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        // find the intersection point ...
        // using Floyd's cycle detection ...
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // find the entrance of the cycle ...
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        System.out.println("");

        return tortoise;
    }
}
