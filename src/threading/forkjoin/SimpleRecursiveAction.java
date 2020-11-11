package threading.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedTask;

    public SimpleRecursiveAction(int simulatedTask) {
        this.simulatedTask = simulatedTask;
    }

    @Override
    protected void compute() {
        if(simulatedTask>100){
            System.out.println("Parallel Execution and Split task :" + simulatedTask);
            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedTask/2); // split it into 2
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedTask/2);

            simpleRecursiveAction1.fork(); //
            simpleRecursiveAction2.fork(); //
        } else {
            System.out.println("no need for parallel execution since task are small :" + simulatedTask);
        }

    }
}
