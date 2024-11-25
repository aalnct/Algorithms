package OAOracle;

public class MergeSortedArrays {

    public static void main(String [] args) {
        int [] array1 = {5,3,1};
        int [] array2 = {4,2,0};

        int[] n = mergeSortedArrays(array1,array2);

        for (int r : n) {
            System.out.println(r);
        }
    }

    static int [] mergeSortedArrays (int [] array1, int [] array2) {
        int m = array1.length;
        int n = array2.length;

        int [] result = new int[m + n];

        int i=0, j=0, k=0;

        while (i < m && j < n) {
            if (array1[i] >= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        // any remaining elements
        while (i < m) {
            result[k++] = array1[i++];
        }
        while (j < n) {
            result[k++] = array2[j++];
        }

        return result;
    }
}
