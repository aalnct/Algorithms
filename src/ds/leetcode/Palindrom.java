package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/7/20.
 */
public class Palindrom {

    public static void main(String[] args) {
        boolean flag = isPalindrom(121);
        System.out.println(flag);
    }

    public static boolean isPalindrom(int x){
        int num = x;
        int reverse = 0;
        int remainder = 0, originalInteger;

        originalInteger = num;

        while(num != 0) {
            remainder = num%10;
            reverse = reverse * 10 + remainder;
            num /=10;
        }

        if(originalInteger == reverse){
            return true;
        }else {
            return false;
        }
    }
}
