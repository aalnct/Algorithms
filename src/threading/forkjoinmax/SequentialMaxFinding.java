package threading.forkjoinmax;

public class SequentialMaxFinding {

    public int sequentialMaxFind (int [] nums , int high) {
        int max = nums[0];

        for (int i=0; i< high; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
