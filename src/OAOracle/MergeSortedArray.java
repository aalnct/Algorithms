package OAOracle;

public class MergeSortedArray {

    public static void main(String[] args) {
        int [] array1 = {1, 3, 5, 0, 0, 0};
        int m = 3;
        int [] array2 = {2, 4, 6};
        int n = 3;

        int [] result = mergeSortedArray(array1,m, array2,n);

        for (int r : result) {
            System.out.println(r);
        }
    }

    static int[] mergeSortedArray (int [] array1, int m, int [] array2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1; // index for merged arrays

        while (i >=0 && j >=0) {
            if (array1[i] > array2[j]) {
                array1[k--] = array1[i--]; // we are gng backwards
            } else {
                array1[k--] = array2[j--];
            }
        }

        // if there are remaining elements in array 2, copy them to array 1
        while (j >=0) {
            array1[k--] = array2[j--];
        }
        return array1;
    }
}
