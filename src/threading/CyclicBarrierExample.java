package threading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by AmitAgarwal on 10/29/20.
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("All tasks are finished");
        });

        for(int i=0;i<5;i++){
            executorService.execute(new CyclicBarrierWorker(i+1, cyclicBarrier));
        }
        executorService.shutdown();
    }
}

class CyclicBarrierWorker implements Runnable {

    private int id;
    private CyclicBarrier cyclicBarrier;
    private Random random;

    public CyclicBarrierWorker (int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    private void doWork() {
        System.out.println("Thread with ID : " + id + " starts the task");
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with ID :" + id + " finished");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CyclicBarrierWorker{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        doWork();
    }
}
