package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/12/20.
 */
public class ReverseInteger2 {

    public static void main(String[] args) {
        int x = 1331;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    private static boolean isPalindrome(int num){
        int x = num; //storing original value for later comparision
        int remainder;
        int reverseInteger = 0;

        while(num != 0){
            remainder = num%10; //get the remainder with every iteration
            reverseInteger = reverseInteger * 10 + remainder;
            num = num/10; // num /=10 (anyone can be used)
        }
        if(x == reverseInteger){
            return true;
        }
        return false;
    }
}
