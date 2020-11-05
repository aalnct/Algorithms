package certification;

/**
 * Created by AmitAgarwal on 1/16/20.
 */
public class InnerClassRule {

    public static void main(String [] args){
        class Data {

        }
        /**
         *  Method local inner class should be declared before calling
         */
        Data data = new Data();
    }

}

class ClassA {

    public static void main(String [] args){
        ClassA classA = new ClassA();
        ClassA.InnerClass ion = new ClassA.InnerClass(); /*to call static inner class we do not have to create an instance of outer
                                                           class*/
    }

    public static class InnerClass {
        private String name;

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

    }

    public  class Inner {
        /**
         * inner class cannot have static
         */
        private final Integer i = new Integer(10);
        public static final String STR = "constant"; /**
            only static member of non static inner class is constant
         **/
    }
}
