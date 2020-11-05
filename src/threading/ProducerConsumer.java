package threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitAgarwal on 10/26/20.
 */

class Processor {

    private List<Integer> arrayList = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException{
        synchronized (lock) {
            while(true){
                if(arrayList.size() == UPPER_LIMIT){
                    System.out.println("Waiting to remove item....");
                    lock.wait();
                }else {
                    System.out.println("Adding :" + value);
                    arrayList.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException{
        synchronized (lock) {
            while(true){
                if(arrayList.size() == LOWER_LIMIT){
                    System.out.println("Waiting to add item....");
                    lock.wait();
                }else {
                    System.out.println("Removing :" + arrayList.remove(arrayList.size()-1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
public class ProducerConsumer {

    public static void main(String[] args) {

        Processor processor = new Processor();

        Thread t1 = new Thread(() -> {
            try{
                processor.producer();
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                processor.consumer();
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }
}
