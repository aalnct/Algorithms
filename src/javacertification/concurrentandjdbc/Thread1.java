package javacertification.concurrentandjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Thread1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new Counter());
        Thread t3 = new Thread(new Counter());

        Thread [] threads = {t1,t2,t3};

        // you cannot predict the order of threads in below given conditions
        for (Thread thread : threads) {
            thread.start();
        }

        // only single thread is fine for this scenario
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Void> future = es.submit(new Caller("call"));
        System.out.println(future.get());

        // if we do not call shutdown method, thread will run for infinite period of time
        es.shutdown();

        ExecutorService es1 = Executors.newSingleThreadExecutor();
        MyCallable myCallable = new MyCallable(100);
        System.out.println(es1.submit(myCallable).get());
        System.out.println(es1.submit(myCallable).get());

        // to shutdown thread gracefully
        es1.shutdown();

        ExecutorService es2 = Executors.newSingleThreadExecutor();
        MyCallable myCallable1 = new MyCallable(10);
        MyThread myThread = new MyThread(10);
        System.out.println(es2.submit(myCallable1).get());

        // why it is giving a null value here ?
        Future<MyThread> myThreadFuture = (Future<MyThread>) es2.submit(myThread);
        System.out.println(myThreadFuture.get());

        es2.shutdown();

        ExecutorService es3 = Executors.newFixedThreadPool(1);
        // MyThread myThread1 = new MyThread("ocp");
        // Future future1 = es3.submit(myThread1);
        // this will throw an compilation error since get () is void return
        // Integer temp = (Integer) future.get();
        // es3.shutdown();
        es3.execute(new Printer());
        es3.shutdown();

        ExecutorService es4 = Executors.newFixedThreadPool(1);
        es4.submit(new Printer1());
        System.out.println("HELLO");
        es4.shutdown();

        List<String> list1 = new ArrayList<>();
        list1.add("Melon");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Mango");

        List<String> list2 = new CopyOnWriteArrayList<>(list1);
        for (String s : list1) {
            //list1.removeIf(str -> str.startsWith("M"));
            System.out.println(s);
        }

        // System.out.println(list1);
        // System.out.println(list2);

        ExecutorService es5 = Executors.newSingleThreadExecutor();
        Future<String> f = es5.submit(() -> "Hello");

        // Future<String> f1 = es5.execute(() -> "HELLO");
        es5.execute(() -> System.out.println("HELLO123"));
        System.out.println(f.get());
        es5.shutdownNow();
    }
}

class Printer implements Runnable{

    @Override
    public void run() {
        System.out.println("Printing");
    }
}

class Printer1 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("DONE");
        return null;
    }
}

class Counter implements Runnable{

    private static int i = 3;

    @Override
    public void run() {
        System.out.println(i--);
    }
}

class Caller implements Callable<Void> {
    String str;

    public Caller (String str) {
        this.str = str;
    }

    @Override
    public Void call() throws Exception {
        System.out.println(str.toUpperCase());
        return null;
    }
}

class MyCallable implements Callable<Integer> {

    private Integer i;

    public MyCallable (Integer i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        return --i;
    }
}

class MyThread implements Runnable {
    private int i;
    // private String str;

   /* MyThread (String str){
        this.str = str;
    }*/

    MyThread (int i) {
        this.i = i;
    }

    public void run () {
        // System.out.println(str.toUpperCase());
        i++;
    }
}

