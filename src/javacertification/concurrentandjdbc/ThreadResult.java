package javacertification.concurrentandjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadResult {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new Counter2());
        Thread t2 = new Thread(new Counter2());
        Thread t3 = new Thread(new Counter2());

        Thread[] t = {t1,t2,t3};
            for (Thread tt: t) {
                tt.start();
        }


        ExecutorService es = Executors.newSingleThreadExecutor();
        MyThread1 myThread1 = new MyThread1("ocp");
        Future future = es.submit(myThread1);
        Integer integer =(Integer) future.get();
        System.out.println(integer);
        es.shutdown();


        // CopyOnWriteArrayList - on every modification a fresh copy of underlying array is created
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Melon");
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        for (String s : list) {
            list.removeIf(str -> str.startsWith("M"));
            System.out.println(s);
        }

        List<String> list1 = new ArrayList<>(); // arraylist on modification while iterating will throw an exception --> Concurrent Modification Exception
        list1.add("Melon");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Mango");

        for (String s : list1) {
            list1.removeIf(str -> str.startsWith("M"));
            System.out.println(s);
        }

    }
}

class MyThread1 implements Runnable {

    private String str;

    MyThread1 (String str) {this.str = str;}


    @Override
    public void run() {
        System.out.println(str.toUpperCase());
    }
}

class Counter2 implements Runnable {

    private static int i = 3;

    @Override
    public void run() {
        System.out.println(i--);
    }
}