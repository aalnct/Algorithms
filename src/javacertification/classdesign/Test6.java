package javacertification.classdesign;

public class Test6 {
    public static void main(String[] args) {
        Animal3.vaccinating();
    }
}

abstract class Animal3 {
    public static void vaccinating () {
        System.out.println("Vaccinating....");
    }

    // abstract class cannot be private
    /*private abstract void treating ();*/
}

