package threading.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Application {
    public static void main(String[] args) {
        // create threads based on number of processors
     /*   ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        Random random = new Random();
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(random.nextInt(1000));
        //forkJoinPool.execute(simpleRecursiveAction);
        forkJoinPool.invoke(simpleRecursiveAction);*/


        ForkJoinPool pool = new ForkJoinPool(4);
        SimpleRecursiveAction1 action = new SimpleRecursiveAction1(1000);

        // what is the difference b/w invoke and execute
        pool.invoke(action);
    }
}
