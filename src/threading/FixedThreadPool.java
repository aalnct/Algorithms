package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by AmitAgarwal on 10/28/20.
 */

class Work implements Runnable{

    private int id;

    public Work(int id){this.id=id;}

    @Override
    public void run(){
        System.out.println("Work ID :" + id + " work thread id : " + Thread.currentThread().getId());
        long duration = (long)(Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            executorService.execute(new Work(i));
        }

        // shutdown the executor service
        executorService.shutdown();

        try { // if wants to shutdown immediately
            if(executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        }catch (InterruptedException ex) {
            ex.printStackTrace();
            executorService.shutdownNow();
        }
    }
}
