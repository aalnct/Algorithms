package javacertification.concurrentandjdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Thread4 {
    private static StringBuilder RES = new StringBuilder();
    public static void main(String[] args) {
        Adder adder = new Adder(1,20);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(adder);
        forkJoinPool.invoke(new Task());
        forkJoinPool.invoke(new Adder());
        System.out.println(adder.total);

        List<String > list = new ArrayList<>(Arrays.asList("A","B", "C", "D", "E", "F", "G", "H", "I", "J"));
        list.parallelStream().forEach(RES::append);
        System.out.println(RES);

        System.out.println(list.stream().isParallel());
        System.out.println(list.stream().parallel().isParallel());
        System.out.println(list.parallelStream().isParallel());

        IntStream intStream = IntStream.rangeClosed(1,5);
        System.out.println(intStream.parallel().reduce((x,y) -> x+y).getAsInt());

        System.out.println("****");

        List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());
        IntStream intStream1 = IntStream.rangeClosed(1,7);
        intStream1.parallel().map(
                x -> {
                    integerList.add(x);
                    return x;
                }).forEachOrdered(System.out::print);
        System.out.println();
        integerList.forEach(System.out::print);

        System.out.println("");

        String s1 = Arrays.asList("A", "E", "I", "O", "U").stream()
                .reduce("" , String::concat);
        System.out.println(s1);
        String s2 = Arrays.asList("A", "E", "I", "O", "U").stream()
                .parallel().reduce("", String::concat);

        System.out.println(s2);
        System.out.println(s1.equals(s2));

        System.out.println();

        String str1 = Stream.iterate(1, i -> i + 1).limit(10)
                .reduce("", (i, s) -> i + s, (s11, s22) -> s11 + s22);

        String str2 = Stream.iterate(1, i -> i + 1).limit(10).parallel().
                reduce("", (i, s) -> i + s, (s11, s22) -> s11 + s22);

        System.out.println(str1.equals(str2));

        Stream<String> stringStream = Stream.of("J","A","V", "A");
        String text = stringStream.parallel().reduce(String::concat).get();
        System.out.println(text);

        Counter1 c1 = new Counter1();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);

        Thread [] threads = {t1,t2,t3};
        for (Thread t : threads) {
            t.start();
        }

        List<Book> books = new ArrayList<>();
        books.add(new Book("9781976704031", 9.99));
        books.add(new Book("9781976704032", 15.99));

        Book b = books.stream().reduce(new Book("9781976704033", 0.0)
        , (b1,b2) -> {
            b1.price = b1.price + b2.price;
            return new Book(b1.isbn, b1.price);
        });

        books.add(b);

        books.parallelStream().reduce(
                (x,y) -> x.price > y.price ? x : y)
                .ifPresent(System.out::println);
    }
}

class Counter1 implements Runnable {

    //
    private AtomicInteger ai = new AtomicInteger(3);

    // private static int a = new Integer(3);

    public void run () {
        System.out.println(ai.getAndDecrement());
       // System.out.println(a--);
    }

}

class Task extends RecursiveTask<Object> {

    @Override
    protected Long compute() {
        return null;
    }
}

class TestingRunnable extends ForkJoinPool{

}

class Adder extends RecursiveAction{

    private int from;
    private int to;
    int total = 0;

    public Adder () {}

    Adder (int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected void compute() {
        if ((to-from) <= 4) {
            int sum = 0;
            for (int i= from; i <= to; i++) {
                sum +=i;
            }
            total += sum;
        } else {
            int mid = (from + to)/2;
            Adder first = new Adder(from,mid);
            Adder second = new Adder(mid + 1, to);
            invokeAll(first,second);
        }
    }
}