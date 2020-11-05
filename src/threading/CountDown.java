package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by AmitAgarwal on 10/29/20.
 */
public class CountDown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // creating a single thread
        CountDownLatch countDownLatch = new CountDownLatch(5); // number of times it must be invoked before
                                                              // threads can be pass through

        for(int i=0;i<5;i++){
            executorService.execute(new WorkerThreads(i+1, countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All Pre-requisites are done.....");
        executorService.shutdown();

    }
}

class WorkerThreads implements Runnable{

    private int id;
    private CountDownLatch countDownLatch;

    public WorkerThreads(int id, CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        doWork();
        countDownLatch.countDown(); // will reduce the count of latch, till it reaches zero
    }

    private void doWork() {
        System.out.println("Thread with id :" + this.id + " starts working.....");
        try {
            TimeUnit.SECONDS.sleep(1); // sleeping for 1 second
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
