package restart.array.advance.knapsack;


import java.util.Arrays;
import java.util.Comparator;

class Items {
    int weight;
    int value; // you can also call this profit

    public Items (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class FractionalKnapSack {

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println(fractionalKnapSack(weights,values,capacity));
    }

    private static double fractionalKnapSack (int [] weight, int [] value, int capacity) { // this capacity is also total weight
        Items[] items = new Items[weight.length];

        for (int i=0; i < weight.length; i++) {
            items [i] = new Items(weight[i],value[i]);
        }

        Arrays.sort(items, (o1, o2) -> {
            double r1 = (double) o1.value/o1.weight;
            double r2 = (double) o2.value/o2.weight;
            return Double.compare(r1,r2);
        });

        double totalValue = 0;

        for (Items item : items) {
            if(capacity == 0) {
                break;
            }

            if (item.weight <= capacity) {
                capacity =capacity - item.weight;
                totalValue = totalValue + item.value;
            } else {
                // take the fraction (since the capacity is almost at limit)
                totalValue += item.value * ((double) capacity/item.weight);
                capacity = 0;
            }
        }
        return totalValue;
    }

}
