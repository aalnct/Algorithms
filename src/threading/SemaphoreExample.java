package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by AmitAgarwal on 10/27/20.
 */

enum Download {

    INSTANCE;

    private Semaphore semaphore = new Semaphore(3,true);

    public void downloadData(){
        try {
            semaphore.acquire(); //acquiring locks
            download();
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally {
            semaphore.release(); // releasing all the lock
        }
    }

    private void download() {
        System.out.println("Downloading data from the web");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i=0;i<12;i++){
            service.execute(() -> {
                Download.INSTANCE.downloadData();
            });
        }
    }
}
