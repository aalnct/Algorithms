/**
 * Created by AmitAgarwal on 11/20/18.
 */
public class MaximumProductArray {
    public static void main(String [] args){
        int [] array = { -6, 4, -5, 8, -10, 0, 8 };
        findMaximumProduct(array);
    }

    private static int findMaximumProduct(int[] array){
        int maxEnding = 0;
        int minEnding = 0;
        int maxSoFar = 0; //to store the maximum product so far

        for(int a : array){
            int temp = maxEnding;
            //update maximum product ending at current index
            maxEnding = Integer.max(a, Integer.max(a*maxEnding, a*minEnding));
            //update minimum product ending at current index
            minEnding = Integer.min(a, Integer.min(a*temp,a*minEnding));

            maxSoFar = Integer.max(minEnding,maxEnding);
        }
        return maxSoFar;
    }
}
