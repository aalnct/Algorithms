package javacertification.functionalinterfaceandstreamapi;

import java.util.Comparator;

public class Fruit implements Comparable<Fruit>, Comparator<Fruit> {

    String name;
    String countryOfOrigin;

    Fruit () {}

    Fruit (String name, String countryOfOrigin) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                '}';
    }

    @Override
    public int compareTo(Fruit o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.countryOfOrigin.compareToIgnoreCase(o2.countryOfOrigin);
    }

    public static int comp (String s1, String s2) {
        return s2.compareToIgnoreCase(s1);
    }
}
