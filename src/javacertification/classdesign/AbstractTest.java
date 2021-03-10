package javacertification.classdesign;

public class AbstractTest {
    public static void main(String[] args) {
        Animal[] animals = new Dog[2];
        animals[0] = new Dog();
        //animals[1] = new Cat();

        Animal animal = new Cat();
        animal.eat();

        animals[0].eat();
        //animals[1].eat();
    }

}

abstract class Animal {
    abstract void eat ();
}

class Dog extends Animal {

    void eat() {
        System.out.println("Dogs eats buiscuit");
    }
}

class Cat extends Animal {
    void eat () {
        System.out.println("Cats eats fish");
    }
}
