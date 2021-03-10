package fb;

public class MergeSortedArray {

    public static void main(String[] args) {
        int [] arr1 = new int[]{1,3,5};
        int [] arr2 = new int[]{2,4, 6, 0, 0, 0};
        mergeSortedArray(arr1,arr2);
    }

    static void mergeSortedArray(int [] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int len1 = array1.length;
        int len2 = array2.length;
        int[] array3 = new int[len1 + len2];

        while (i < len1 && j< len2) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];
                k++;
                i++;
            }else  {
                array3[k] = array2[j];
                k++;
                j++;
            }
        }

        while (i<len1) {
            array3[k] = array1[i];
            k++;
            i++;
        }
        while (j<len2 && array2[j] !=0) {
            array3[k] = array2[j];
            k++;
            j++;
        }
        for (int in : array3) {
            System.out.println(in);
        }
    }
}
