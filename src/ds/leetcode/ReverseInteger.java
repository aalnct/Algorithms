package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/7/20.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int result = reverse(-123);
        System.out.println(result);
    }

    public static int reverse(int x){
        String result = x<0? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString() : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(result);
        }catch (Exception ex) {
            return 0;
        }
    }

}
