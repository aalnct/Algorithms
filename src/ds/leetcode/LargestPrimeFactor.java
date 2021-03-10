package ds.leetcode;

public class LargestPrimeFactor {

    private static int largestPrimeFactor (int n) {
        int i;
        int copy = n;
        for (i = 2; i <= copy; i++) {
            if (copy%i == 0){
                copy /= i;
                i--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int prime = largestPrimeFactor(15);
        System.out.println(prime);
    }

}
