package OAOracle;

public class InversionCount {

    public static void main(String[] args) {
        int [] array = {1, 20, 6, 4, 5};
        System.out.println(inversionCount(array));
        System.out.println(countInversion(array));
    }

    // brute force approach ...
    static int inversionCount (int [] array) {
        int n = array.length;
        int inversionCount = 0;

        for (int i=0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (array[i] > array[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    // using merge sort

    static int countInversion(int [] array) {
        int [] temp = new int[array.length];

        return mergeSort(array,temp,0, array.length-1);
    }

    private static int mergeSort (int [] array, int [] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left)/2;

            count +=mergeSort(array,temp,left,mid);
            count +=mergeSort(array,temp,mid+1,right);

            count += merge(array,temp,left,mid,right);

        }
        return count;
    }

    private static int merge (int[] array, int[] temp, int left, int mid, int right) {
        int count = 0;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count +=mid-i+1; // since array is sorted, this will count of all the inversion it will need
                                // from there on ...
            }
        }

        while (i <=mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i =left; i <= right; i++) {
            array[i] = temp[i];
        }
        return count;
    }
}
