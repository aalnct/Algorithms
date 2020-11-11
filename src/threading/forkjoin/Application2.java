package threading.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Application2 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Random random = new Random();
        SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(random.nextInt(1000));
        forkJoinPool.invoke(simpleRecursiveTask);
    }
}
