package threading.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction1 extends RecursiveAction {

    int numberOfTask;

    public
    SimpleRecursiveAction1 (int numberOfTask) {
        this.numberOfTask = numberOfTask;
    }

    // abstract method in RecursiveAction
    @Override
    public void compute () {
        if (numberOfTask > 100) {
            // divide the task 1 in half
            System.out.println("Doing the parallel execution using ForkJoin algorithm ...." + numberOfTask);

            SimpleRecursiveAction1  action1 = new SimpleRecursiveAction1(numberOfTask/2);

            // work on the rest of the task
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(numberOfTask/2);

            action1.fork();
            action2.fork();
        } else {
            System.out.println("No need for parallel execution " + numberOfTask);
        }
    }
}
