package ds.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitAgarwal on 6/28/20.
 */

/**
 *
 * a number is self dividing if it is divisible by all digits in that number
 * for example - 128 (should be divisible by 1, 2, 8) etc....
 */

public class SelfDividingNumber {

    public static void main(String[] args) {
        selfDividingNumber(1,22).forEach(i -> System.out.println(i));
    }

    public static List<Integer> selfDividingNumber(int left, int right){
        List<Integer> list = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(selfDividing(i)) list.add(i);
        }
        return list;
    }

    private static boolean selfDividing(int i){
        for(char c: String.valueOf(i).toCharArray()){
            if(c == '0' || (i%(c-'0') >0)){
                return false;
            }
        }
        return true;
    }
}
