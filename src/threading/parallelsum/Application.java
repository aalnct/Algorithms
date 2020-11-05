package threading.parallelsum;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        SequentialSum sequentialSum = new SequentialSum();
        int [] nums = new int[100000000];
        Random random = new Random();

        for (int i=0; i< nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        long start = System.currentTimeMillis();
        System.out.println(sequentialSum.sum(nums));

        System.out.println("Current Processing time (sequential)  :" + (System.currentTimeMillis() - start));
    }
}
