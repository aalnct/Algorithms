package threading.parallelsum;

public class ParallelWorker extends Thread{
    private int[] nums;
    private int lowIndex;
    private int highIndex;
    private int partialSum;

    public ParallelWorker (int[] nums, int lowIndex , int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    // sum b/w the range

    public int getPartialSum () {
        return this.partialSum;
    }

    @Override
    public void run() {
        partialSum = 0;

        for (int i=lowIndex; i<highIndex; i++) {
            partialSum = partialSum + nums[i];
        }
    }
}
