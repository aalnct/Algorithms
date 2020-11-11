package threading.forkjoinmax;

import java.util.Random;

public class Application {
    public static Integer THRESHOLD = 0;

    public static void main(String[] args) {
        int [] nums = initializeNums();
        THRESHOLD = nums.length/Runtime.getRuntime().availableProcessors();
    }

    public static int[] initializeNums () {
        Random random = new Random();
        int [] nums = new int[1000];

        for(int i=0; i < 10000; i++) {
            nums[i] = random.nextInt(1000);
        }
        return nums;
    }
}
