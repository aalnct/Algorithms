package javacertification.concurrentandjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es1 = Executors.newFixedThreadPool(1000);
        Accumulator a = new Accumulator();
        for (int i=1; i<=1000; i++) {
            int x = i;
            es1.execute(() -> a.accumulate(x));
        }
        es1.shutdown();
        System.out.println(a.getList().size());

        ExecutorService es2 = Executors.newFixedThreadPool(10);
        Future<?> future1 = es2.submit(Thread3::print);
        Future<?> future2 = es2.submit(Thread3::get);
        System.out.println(future1.get());
        System.out.println(future2.get());

        es2.shutdown();

        AtomicInteger ai = new AtomicInteger(10);
        // System.out.println(ai.addAndGet(1) + " : " + ai);
        System.out.println(ai.incrementAndGet() + ":" + ai.get());
    }

    private static void print () {
        System.out.println("PRINT");
    }

    private static Integer get () {
        return 10;
    }
}
class Accumulator {
    private List<Integer> list = new ArrayList<>();

    // since this method is synchronized, only one thread can enter it at a given time
    public synchronized void accumulate (int i) {
        this.list.add(i);
    }

    public List<Integer> getList () {
        return list;
    }
}
