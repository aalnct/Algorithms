package ds.leetcode.BinarySearchProblems;

/**
 * Created by AmitAgarwal on 5/23/20.
 */
public class ArrangingCoine {

    public static void main(String[] args) {
        int result =  arrangeCoins(8);
        System.out.println(result);
    }

    public static int arrangeCoins(int n){
        int count;
        for(count=1;count<=n;count++){
            n = n - count;
        }
        return count-1;
    }
}
