package threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by AmitAgarwal on 10/28/20.
 */

class StockMarketBroker implements Runnable{

    @Override
    public void run(){
        System.out.println("Running Stock Market Broker thread");
    }
}

public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(new StockMarketBroker(), 1000, 5000, TimeUnit.MILLISECONDS);
    }
}
