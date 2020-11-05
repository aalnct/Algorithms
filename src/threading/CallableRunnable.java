package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by AmitAgarwal on 10/28/20.
 */
class Processor1 implements Callable<String> {

    private int id;

    public Processor1 (int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "id: " + id;
    }
}

public class CallableRunnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list =  new ArrayList<>();

        for(int i=0;i<5;i++){
            Future<String> future = executorService.submit(new Processor1(i+1));
            list.add(future);
        }

        try{
            for(Future<String> f : list) System.out.println(f.get());
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        executorService.shutdown(); // will not interrupt underlying executions, will not submit a new one

    }
}
