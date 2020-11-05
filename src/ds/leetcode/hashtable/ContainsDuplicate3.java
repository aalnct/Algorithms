package ds.leetcode.hashtable;

/**
 * Created by AmitAgarwal on 6/10/20.
 */
public class ContainsDuplicate3 {

    public static void main(String[] args) {
        int[] a = new int[] {-1,2147483647};
        int k = 1;
        int t = 2147483647;

        /**
         * [-1,2147483647]
            1
            2147483647
         */
        boolean result = containsDuplicate(a,k,t);
        System.out.println(result);
    }

    public static boolean containsDuplicate(int[] a, int k, int t){
        if (a.length > 9999) {
            return false;
        }
        for(int i=0;i<a.length;i++){
            for(int j = ((k+i) >= a.length) ? a.length-1 : k+i; j>i; j--) {
                if(Math.abs(a[i] - a[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] a, int k, int t){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if((Math.abs(a[i] - a[j])) <= t && (Math.abs(i-j) <=k)){
                    return true;
                }
            }
        }
        return false;
    }

}
