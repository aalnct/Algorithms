package javacertification.classdesign;

// ArrayStoreException
public class Test2 {
    public static void main(String[] args) {
        /**
         * if animal class is initialized it with child class (Dogs2), you cannot call
         * parent class object on it, will throw an exception
         */
        Animal2[] animal2 = new Animal2[2];
        animal2[0] = new Animal2();
        animal2[1] = new Dogs2();

        animal2[0].eat();
        animal2[1].eat();
    }
}

class Animal2 {
    public void eat () {
        System.out.println("Animal eats");
    }
}

class Dogs2 extends Animal2 {
    public void eat () {
        System.out.println("Dog eats");
    }
}
