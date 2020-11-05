package threading;

/**
 * Created by AmitAgarwal on 10/27/20.
 */

class Worker1 implements Runnable{

    private volatile boolean terminated; // make this as volatile to make sure that it is always read from RAM

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public void run() {
        while(!isTerminated()){
            System.out.println("Worker1 class is running");
            try {
                Thread.sleep(300);
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


}

public class Volatile {

    public static void main(String[] args) throws InterruptedException {
        Worker1 worker1 = new Worker1();
        Thread t1 = new Thread(worker1);

        t1.start();
        Thread.sleep(500);
        worker1.setTerminated(true);
        System.out.println("Algo terminated....");
    }

}
