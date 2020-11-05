package threading;

/**
 * Created by AmitAgarwal on 10/25/20.
 */

class DeamonThread implements Runnable {

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing Deamon Thread");
        }
    }
}

class WorkerThread implements Runnable {
    @Override
    public void run() {
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing Worker Thread");
        }

}

public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeamonThread());
        t1.setDaemon(true);
        Thread t2 = new Thread(new WorkerThread());
        t1.start();
        t2.start();
    }
}