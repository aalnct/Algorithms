package threading.parallelsum;

public class ParallelSum {

    private ParallelWorker [] sum;
    private int numberOfThreads;

    public ParallelSum (int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.sum = new ParallelWorker[numberOfThreads];
    }

    public int sum (int [] nums) {
        int steps = (int) Math.ceil(nums.length * 1.0 / numberOfThreads);
        for (int i=0; i < numberOfThreads; i++) {
            sum[i] = new ParallelWorker(nums,i*steps , (i+1)*steps);
            sum[i].start();
        }

        for (ParallelWorker worker : sum) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int total = 0;
        for (ParallelWorker worker : sum)
            total += worker.getPartialSum();

        return total;
    }
}
