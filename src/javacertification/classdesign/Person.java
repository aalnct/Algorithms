package javacertification.classdesign;

public class Person {

    String name;
    int age;

    public Person () {
        this.name = "Virat";
        this.age = 29;
    }

    public String toString() {
        return "Name :" + this.name + "age :" + this.age;
    }

    public static void main(String[] args) {
        System.out.println(new Person());
    }
}
