package javacertification.classdesign;

public abstract class Child extends Player3{
    public static void main(String[] args) {
        new Player3().method();
    }
}

class Player3 {
    public void method () {
        System.out.println("Parent class");
    }
}
