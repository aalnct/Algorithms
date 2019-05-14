/**
 * Created by AmitAgarwal on 11/20/18.
 */
public class Deadlock {

    public static void main(String[] args){
        Deadlock d1 = new Deadlock();
        Deadlock d2 = new Deadlock();

        Thread t1 = new Thread(new ThreadA(d1,d2),"Thread-1");
        Thread t2 = new Thread(new ThreadB(d1,d2),"Thread-2");

        t1.start();
        t2.start();
    }
}

class ThreadA implements Runnable{

    private Deadlock object1;
    private Deadlock object2;

    @Override
    public void run(){
        synchronized (object1){
            System.out.println("" + Thread.currentThread().getName());
            synchronized (object2){
                System.out.println("Reached here");
            }
        }

    }

    public ThreadA(Deadlock object1, Deadlock object2){
        this.object1 = object1;
        this.object2 = object2;
    }
}

class ThreadB implements Runnable{

    private Deadlock object1;
    private Deadlock object2;

    public ThreadB(Deadlock object1,Deadlock object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run(){
        synchronized (object2){
            System.out.println("" + Thread.currentThread().getName());
            synchronized (object1){
                System.out.println("Reached here");
            }
        }

    }
}
