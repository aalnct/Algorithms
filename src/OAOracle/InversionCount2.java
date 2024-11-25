package OAOracle;

public class InversionCount2 {

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int inversionCount = inversionCount(arr);
        System.out.println("Inversion count: " + inversionCount);
    }

    static int inversionCount (int [] array) {
        int [] temp = new int[array.length];
        return mergeSort(array,temp,0,array.length-1);
    }

    static int mergeSort(int [] array, int [] temp, int left,int right) {
        int inversionCount = 0;

        if (left < right) {
            int mid = (left + right)/2;
            inversionCount +=mergeSort(array,temp,left,mid);
            inversionCount +=mergeSort(array,temp,mid+1,right);

            inversionCount +=mergeSorting(array,temp,left,mid,right);
        }

        return inversionCount;
    }

    static int mergeSorting (int [] array, int [] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int inversionCount = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                inversionCount += (mid-i+1);
            }
        }

        // if any number left ...
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // if any number left on right ...
        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i=left; i <= right; i++) {
            array[i] = temp[i];
        }

        return inversionCount;
    }
}
