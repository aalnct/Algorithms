package fb;

public class MergeSort {

    public static void main(String[] args) {
        int [] inputArray = new int[] {10,1,4,90,6,33,22,7,0,1};
        sort(inputArray);
        for (int i : inputArray) {
            System.out.println(i);
        }
    }

    private static void sort(int [] array) {
        mergeSort(array, 0, array.length-1);
    }

    private static void mergeSort(int [] array, int start, int end) {
        if (end <= start) {
            return; // already sorted
        }
        // recursive call to sort entire array

        int mid = (start + end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1, end);
        merge(array, start,mid,end);
    }

    private static void merge (int[] array, int start, int mid, int end) {
        // need to create a temp array to store the sorted values
        int[] aux = new int[end - start + 1];
        int k = 0; // index for auxillary array

        int leftSlot = start;
        int rightSlot = mid+1;

        /**
         * left slot should not cross mid point
         * right slot should not cross end point
         */
        while (leftSlot <= mid && rightSlot <= end) {
            if (array[leftSlot] < array[rightSlot]) {
                aux[k] = array[leftSlot];
                leftSlot++;
            }else {
                aux[k] = array[rightSlot];
                rightSlot++;
            }
            k++; // need to increment the index for auxillary array to store value in correct index
        }

        // now what if one side of the array is completely sorted ? we need to make sure that we are covering both the arrays
        if (leftSlot <= mid) {
                while (leftSlot <= mid) {
                aux[k] = array[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= end) {
                while (rightSlot <= end) {
                    aux[k] = array[rightSlot];
                    rightSlot++;
                    k++;
            }
        }

        // copying array
        for (int i=0;i<aux.length;i++) {
            array[start+i] = aux[i];
        }
    }
}
