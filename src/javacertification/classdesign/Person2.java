package javacertification.classdesign;

public class Person2 {

    String name;
    int age;

    Person2 () {
        this.age = 29;
        this.name = "Virat";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int hashcode () {
        return 100;
    }

    public static void main(String[] args) {
        System.out.println(new Person2());
    }
}
