package javacertification.concurrentandjdbc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        Match match = new Match();
        CyclicBarrier cb = new CyclicBarrier(2, match);
        Player1 p1 = new Player1(cb);
        new Player1(cb);
        // p1.start();
        // new Player1(cb).start();
        /*ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Player(cb));
        executorService.execute(new Player(cb));
        executorService.shutdown();*/

        IntStream.rangeClosed(1,10).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,10).forEachOrdered(System.out::print);

        System.out.println();

        int res = IntStream.range(1,1000).parallel()
                .filter(i -> i>50).findFirst().getAsInt();
        System.out.println(res);

        Callable<String> c = new Callable<String>() {

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                return "HELLO";
            }
        };

        ExecutorService es1 = Executors.newFixedThreadPool(10);
        List<Callable<String>> list = Arrays.asList(c,c,c,c,c);
        List<Future<String>> f1 = es1.invokeAll(list);
        System.out.println(f1.size());
        es1.shutdown();

    }
}

class Player1 extends Thread{
    CyclicBarrier cyclicBarrier;

    public Player1 () {
        super();
    }

    public Player1 (CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.start();
    }

    public void run () {
        try {
            cyclicBarrier.await();
        }catch (InterruptedException | BrokenBarrierException bbe) {
            bbe.printStackTrace();
        }
    }
}

class Player extends Thread{
    CyclicBarrier cyclicBarrier;

    public Player (CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run () {
        try {
            cyclicBarrier.await();
        }catch (InterruptedException | BrokenBarrierException bbe) {

        }
    }
}

class Match implements Runnable{

    @Override
    public void run () {
        System.out.println("Match is starting .....");
    }
}