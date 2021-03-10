package javacertification.classdesign;

public class Test5 {
    public static void main(String[] args) {

    }
}

class Player6 {
    String name;
    int age;

    Player6 () {
        this.name = "Yuvraj";
        this.age = 20;
    }

    public String toString () {
        return name + " " + age;
    }

    /**
     * class getClass() method is final, cannot override it
     */
   /* public Class getClass () {
        return super.getClass();
    }*/
}
