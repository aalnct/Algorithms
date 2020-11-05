package stringpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by AmitAgarwal on 11/11/19.
 */
public class Singleton {

    private static volatile Singleton soleInstance = null; //volatile - make sure that value is always read from main memory

    private Singleton() {
        System.out.println("Creating ..");
    }
        // a way to avoid breaking Singleton
        static class Holder {
          static final Singleton INSTANCE = new Singleton();
        }

    public static Singleton getInstance(){
        // Double checked locking
        if(soleInstance == null){
            synchronized (Singleton.class){
                if(soleInstance == null){ //in case before thread gets lock another thread already created the instance
                    soleInstance = new Singleton();
                }
            }
        }
        return soleInstance;
    }
}

class TestClass {
    static void useSingleton(){
        Singleton singleton = Singleton.getInstance();
        print("singleton" , singleton);
    }

    public static void main(String [] args) throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(TestClass::useSingleton);
        service.submit(TestClass::useSingleton);
    }

    private static void print(String name, Singleton object) {
        System.out.println(String.format("Object : %s, Hashcode: %d", name, object.hashCode()));
    }
}

