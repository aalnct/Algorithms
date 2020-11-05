package comparator2;

import java.util.Comparator;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class Laptop implements Comparable<Laptop>{

    private int price;
    private int memory;
    private String brand;

    public Laptop(int price, int memory, String brand) {
        this.price = price;
        this.memory = memory;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", memory=" + memory +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public int compareTo(Laptop lap2) {
        // this > lap2 -> 1
        // this < lap2 -> -1
        // this == lap2 = 0

        if(this.getPrice() > lap2.getPrice()){
            return 1;
        }else if(this.getPrice() < lap2.getPrice()){
            return -1;
        }
        return 0;
    }
}
