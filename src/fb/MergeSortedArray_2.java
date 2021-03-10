package fb;

public class MergeSortedArray_2 {

    public static void main(String[] args) {
        int [] arr1 = new int[]{};
        int [] arr2 = new int[]{1};
        merge(arr1,arr2);
    }

    static void merge(int[] arr1, int [] arr2) {
        int index1 = arr1.length-1;
        int index2 = arr1.length-1;

        int pointer = arr2.length-1;

        while (index1 >= 0 && index2 >= 0) {
            if (arr1[index1] >= arr2[index2]) {
                arr2[pointer] = arr1[index1];
                pointer--;
                index1--;
            } else if (arr1[index1] < arr2[index2]) {
                arr2[pointer] = arr2[index2];
                pointer--;
                index2--;
            }
        }



        while (index1 >= 0) {
            arr2[pointer] = arr1[index1];
            pointer--;
            index1--;
        }

        while (index2 >= 0) {
            arr2[pointer] = arr2[index2];
            pointer--;
            index2--;
        }

        for (int ii : arr2)
            System.out.println(ii);
    }

}
