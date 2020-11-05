package threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AmitAgarwal on 10/27/20.
 */
public class Deadlock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void worker1(){
        lock1.lock();
        System.out.println("Worker1 acquires lock1");

        try{
            Thread.sleep(300);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker 1 acquired lock2");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("Worker2 acquired lock2");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println("Worker2 acquire lock1");

        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        // Java 8 implementation using lambda
        new Thread(deadlock::worker1,"worker1").start();
        new Thread(deadlock::worker2,"worker2").start();
    }
}
