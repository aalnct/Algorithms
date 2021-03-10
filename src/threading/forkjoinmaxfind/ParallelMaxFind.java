package threading.forkjoinmaxfind;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFind extends RecursiveTask<Integer> {

    private int[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMaxFind(int[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    public Integer compute () {
        if (highIndex-lowIndex < Application.THRESHOLD) {
            return computeMax ();
        } else  {
            int midIndex = (highIndex + lowIndex) / 2;
            ParallelMaxFind task1 = new ParallelMaxFind(nums, lowIndex, midIndex);
            ParallelMaxFind task2 = new ParallelMaxFind(nums, midIndex+1, highIndex);

            invokeAll(task1,task2);
            return Math.max(task1.join(), task2.join());
        }
    }

    private int computeMax () {
        int max = nums[lowIndex];
        for (int i = lowIndex; i< highIndex;i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
