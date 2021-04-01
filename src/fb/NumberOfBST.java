package fb;

public class NumberOfBST {

    public static void main(String[] args) {
        int output = numTrees(3);
        System.out.println(output);
    }

    static int numTrees (int n) {
        int[] c = new int[n+1];
        c[0] = 1;
        c[1] = 1;

        for (int i=2;i<=n;i++) {
            for (int j=0; j<i; j++) {
                c[i] +=c[j] * c[i-j-1];
            }
        }

        return c[n];
    }
}
