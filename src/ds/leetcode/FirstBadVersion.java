package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/10/20.
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        firstBadVersionBinarySearch(10);
        firstBadVersionLinearSearch(10);
    }

    /**
     * Using Linear search
     */

    private static int firstBadVersionLinearSearch(int n){
        for(int i=0;i<=n;i++){
            if(isBadVersion(i)){
                return i; // will tell this version is bad
            }
        }
        return 0; // no version is bad
    }

    private static boolean isBadVersion(int i) {
        return false;
    }

    /**
     * Using Binary Search
     */

    private static int firstBadVersionBinarySearch(int n){
        int p = 1;
        int q = n;
        while(p < q){
            int pivot = (p+q)/2;
            if(isBadVersion(pivot)){
                q = pivot;
            }else {
                p = pivot + 1;
            }
        }
        return p;
    }

}
