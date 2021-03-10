package javacertification.classdesign;

public class Test7 {
    public static void main(String[] args) {
        Object p1 = new Player7("Sachin",44);
        Object p2 = new Player7("Sachin",44);
        System.out.println(p1.equals(p2));
    }
}

class Player7 {
    String name;
    int age;

    Player7 (String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player7{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals (Object player7) {
        Player7 that = (Player7)player7;
        if (player7!=null && that.name.equals(this.name)
        && that.age == this.age) {
            return true;
        }
        return false;
    }
}
