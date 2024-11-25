package OAFacebook.repractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArrayList {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,3,4,5);
        int d = 4;
        List<Integer> a = reverseFactor(array,d);
        for (int r : a) {
            System.out.println(r);
        }
    }

    static List<Integer> reverseFactor (List<Integer> array, int d) {
        int n =  array.size();
        d = d % n;
        List<Integer> subList1 = array.subList(0,d);
        List<Integer> subList2 = array.subList(d,n);

        Collections.rotate(subList1,n-d); // rotate till end of array

        for (int i=0; i < d; i++) {
            array.set(i, subList1.get(i));
        }

        for (int i=d; i < n; i++) {
            array.set(i, subList2.get(i-d));
        }

        return array;
    }
}