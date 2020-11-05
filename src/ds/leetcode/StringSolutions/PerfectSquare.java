package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 6/23/20.
 */
public class PerfectSquare {

    public static void main(String[] args) {
        boolean result = isPerfectSquare(808201);
        System.out.println(result);
    }

    public static boolean isPerfectSquare(int nums){
        long left = 2;
        long right = nums/2;
        long guess;

        if(nums<2) return true;

        while(left<=right){
            long pivot = left + (right-left)/2;
            guess = pivot * pivot;

            if(guess == nums){
                return true;
            }else if(guess < nums){
                left = pivot + 1;
            }else {
                right = pivot-1;
            }
        }
        return false;
    }
}
