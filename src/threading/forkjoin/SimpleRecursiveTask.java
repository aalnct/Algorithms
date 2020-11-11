package threading.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulatedTask;

    public SimpleRecursiveTask(int simulatedTask) {
        this.simulatedTask = simulatedTask;
    }

    @Override
    protected Integer compute() {
        if(simulatedTask > 100){
            System.out.println("Parallel Execution of task :" + simulatedTask);
            SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(simulatedTask/2);
            SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(simulatedTask/2);

            simpleRecursiveTask1.fork();
            simpleRecursiveTask2.fork();

            int solution = 0;

            solution += simpleRecursiveTask1.join();
            solution += simpleRecursiveTask2.join();

            return solution;
        }else  {
            System.out.println("No need for parallel task execution :" + simulatedTask );
            return 2*simulatedTask;
        }

    }
}
