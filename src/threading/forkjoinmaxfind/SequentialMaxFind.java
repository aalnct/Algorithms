package threading.forkjoinmaxfind;

import java.util.concurrent.RecursiveTask;

public class SequentialMaxFind {

    private int[] array;
    private int highIndex;
    private int max = 0;

    public SequentialMaxFind (int [] array, int highIndex) {
        this.array = array;
        this.highIndex = highIndex;
    }

    public int computeMax (int [] array, int highIndex) {
        for (int i=0; i< highIndex; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
