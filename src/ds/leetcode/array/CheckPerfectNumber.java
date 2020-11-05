package ds.leetcode.array;

/**
 * Created by AmitAgarwal on 6/28/20.
 */
public class CheckPerfectNumber {

    public static void main(String[] args) {
        boolean flag = checkPerfectNumber(28);
        System.out.println(flag);
    }

    public static boolean checkPerfectNumber(int number){
        if(number<0){
            return false;
        }

        int sum = 0;
        for(int i=1;i*i<number;i++){
            if(number%i==0){
                sum +=i;

                if(i*i != number){
                    sum += number/i;
                }
            }
        }
        return sum-number==number;
    }
}
