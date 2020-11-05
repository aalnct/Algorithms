package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/23/20.
 */
public class NumberParity {
    public static void main(String[] args) {
        short result = parity(10001001);
        System.out.println(result);

    }

    public static short parity(long x){
        short result = 0;
        while(x!=0){
            result ^=(x&1);
            x >>>=1;
        }
        return result;
    }
}
