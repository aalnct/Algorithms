package certification;

/**
 * Created by AmitAgarwal on 1/15/20.
 */
public class Singleton {

    private static Singleton INSTANCE;

    /**
     * Eager Initialization
     */
    private static Singleton INSTANCE2 = new Singleton();

    private Singleton(){}

    /**
     * Lazy Approach
     * @return
     */
    public synchronized static Singleton getINSTANCE(){
        if(INSTANCE == null){
            return INSTANCE = new Singleton();
        }else {
            return INSTANCE;
        }

    }

}
