package threading.forkjoinmaxfind;

import java.util.Random;

public class Application {
    public static int THRESHOLD = 0;

    public static void main(String[] args) {
        int[] nums = initializeNumber();
        THRESHOLD = nums.length / Runtime.getRuntime().availableProcessors();
    }

    private static int[] initializeNumber () {
        Random random = new Random();

        int [] nums = new int[10000];
        for (int i = 0; i< 10000 ; i++)
            nums[i] = random.nextInt(1000);
            return nums;
    }
}
