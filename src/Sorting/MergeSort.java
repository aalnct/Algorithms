package Sorting;

/**
 * Created by AmitAgarwal on 5/16/19.
 */
public class MergeSort {

    public static void sort(int [] inputArray){
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort(int[] inputArray, int start, int end) {
        if(end <= start){
            return; //done traversing the array
        }
        //find the mid
        int mid = (start + end)/2;

        //recursive way
        sort(inputArray,start,mid); // left sort
        sort(inputArray,mid+1,end); // right sort
        merge(inputArray,start,mid,end); // merge after sorting
    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        //create a temporary array
        int tempArray [] = new int[end - start + 1]; //length of array

        // index counter for left side of Array
        int leftSlot = start;

        // index counter for right side of Array
        int rightSlot = mid + 1;

        // index for temp array
        int k = 0;

        while(leftSlot <= mid && rightSlot <= end){ //loop will run till left slot is less than mid value, and right slot is less than end index
            if(inputArray[leftSlot] < inputArray[rightSlot]){
                tempArray[k] = inputArray[leftSlot];
                leftSlot = leftSlot + 1; // incrementing the left slot
            }else {
                tempArray[k] = inputArray[rightSlot];
                rightSlot = rightSlot + 1; // incrementing the right slot
            }

            k = k+1; //need to increment the index of temp array so that value gets copied to correct place
        }

        /**
         * when it gets to here that means the above loop is completed and
         * both the left and right side of array are sorted
         */

        //there can be scenario that right array is sorted and left index is always less than right

        if(leftSlot <= mid){
            while(leftSlot <= mid){
                tempArray[k] = inputArray[leftSlot];
                leftSlot = leftSlot + 1;
                k = k + 1;
            }
        }else if(rightSlot <= end){
            while(rightSlot <=  end){
                tempArray[k] = inputArray[rightSlot];
                rightSlot = rightSlot + 1;
                k = k + 1;
            }
        }
        for(int i=0;i< tempArray.length;i++){
            inputArray[start + i] = tempArray[i];
        }
    }
}
