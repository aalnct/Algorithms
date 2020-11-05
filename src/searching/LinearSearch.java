package searching;

/**
 * Created by AmitAgarwal on 5/8/20.
 */
public class LinearSearch {

    /**
     *
     * @param a
     * @param x
     * @return Linear growth rate - not acceptable O(n)
     */

    public static int search(int[] a, int x){
        for(int i = 0; i < a.length;i++){
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 19;
        int[] a = {10,4,7,9,14,19};
        int i = search(a,x);
        System.out.println(i);
    }
}
