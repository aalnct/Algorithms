package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AmitAgarwal on 10/26/20.
 */

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer () throws InterruptedException{
        lock.lock();
        System.out.println("Producer Method ....");
        condition.await();
        System.out.println("Producer again....");
        lock.unlock();
    }

    public void consumer () throws InterruptedException{
        lock.lock();
        Thread.sleep(2000);
        System.out.println("Consumer Method....");
        condition.signal();
        lock.unlock();
    }
}

public class ProducerConsumerLock {
    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread t1 = new Thread(() -> {
            try{
                worker.producer();
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                worker.consumer();
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
