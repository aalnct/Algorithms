package javacertification.classdesign;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Player());
    }
}

class Player{
    String name;
    int age;

    Player () {
        this.name = "Virat";
        this.age = 29;
    }

    public int hashcode () {
        return 100;
    }
}

abstract class Player2 extends Player{

}
