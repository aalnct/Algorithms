package threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AmitAgarwal on 10/27/20.
 */
public class LiveLock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void worker1() {

        while(true){
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker1 acquires the lock1...");
            System.out.println("Worker1 tries to get lock2");

            if(lock2.tryLock()){
                System.out.println("Worker1 Acquired lock2");
                lock2.unlock();
            }else {
                System.out.println("worker1 cannot acquire lock2");
                continue;
            }

            break;
        }

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        while(true){
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker2 acquired lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(lock1.tryLock()){
                System.out.println("worker2 acquired lock1");
                lock1.unlock();
            }else {
                System.out.println("worker2 cannot acquired lock1");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();
        new Thread(liveLock::worker1,"worker1").start();
        new Thread(liveLock::worker2,"worker2").start();
    }
}
