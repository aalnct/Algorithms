package fb;

public class SubsetOfSet {

    public static void main(String[] args) {
        char[] set = {'a','b','c'};
        printSubSet(set);
    }

    static void printSubSet (char[] set) {
        int n = set.length;

        for (int i=0; i < (1<<n); i++) {
            System.out.print("{");

            // print current subset

            for (int j=0; j <n; j++) {
                if ((i & (1<<j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
