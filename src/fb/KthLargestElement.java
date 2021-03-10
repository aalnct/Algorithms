package fb;

public class KthLargestElement {

    public static void main(String[] args) {
        int arr[] = new int[] { 12, 3, 5, 7, 4, 19, 26 };
        int k = 3;
        int Kth = kthLargestElement(arr,k);
        System.out.println(Kth);
    }

    static int kthLargestElement(int [] array, int k) {
       int start = 0;
       int end = array.length-1;
       int targetIndex = array.length-k;

       while (start <= end) {
           int pp = findPartitionPoint(array,start,end);

           if (pp < targetIndex) {
               start = pp+1;
           } else if(pp > targetIndex) {
               end = pp-1;
           }
           else return array[pp];
       }


        return Integer.MAX_VALUE;
    }

    private static int findPartitionPoint(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start-1; // -1

        for (int j = start; j< end;j++) {
            if(array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;
    }
}
