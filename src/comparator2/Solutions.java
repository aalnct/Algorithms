package comparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class Solutions {

    public static void main(String[] args) {
        /**
         * First using comparable interface
         */
        List<Laptop> laptops = new ArrayList<>();

        laptops.add(new Laptop(100, 10, "Dell"));
        laptops.add(new Laptop(110, 12, "Mac"));
        laptops.add(new Laptop(99, 3, "Acer"));

        Collections.sort(laptops);

        laptops.stream().forEach(l -> System.out.println(l));

        /**
         * second using comparator interface
         */
        laptops = new ArrayList<>();

        laptops.add(new Laptop(100, 0, "HP"));
        laptops.add(new Laptop(11, 12, "Lenovo"));
        laptops.add(new Laptop(99, 2, "IBM"));

        Comparator<Laptop> laptopComparator = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop l1, Laptop l2) {
                if(l1.getMemory() > l2.getMemory()){
                    return 1;
                }else if(l1.getMemory() < l2.getMemory()){
                    return -1;
                }
                return 0;
            }
        };

        Collections.sort(laptops,laptopComparator);

        laptops.stream().forEach(l -> System.out.println(l));
    }
}
