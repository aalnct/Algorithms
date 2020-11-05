package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by AmitAgarwal on 10/28/20.
 */

class Task implements Runnable{

    private int id;

    public Task(int id){this.id=id;}

    @Override
    public void run(){
        System.out.println("Task ID : " + id + " thread id : " + Thread.currentThread().getName());
        long duration = (long)(Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class SingleThreadExecutor{

    public static void main(String[] args) {
        // Executor Service to create a pool of single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            executorService.execute(new Task(i));
        }
        // shutdown Executor
    }
}
