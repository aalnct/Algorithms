package fb;

public class ContiguousSubArray {

    public static void main(String[] args) {
        int [] arr = {2, 4, 7, 1, 5, 3};
        int [] result = countSubArray(arr);
        for (int finalResult : result) {
            System.out.println(finalResult);
        }
    }

    private static int[] countSubArray(int [] arr) {
        int [] output = new int[arr.length]; //this will store the result
        for (int i=0;i < arr.length; i++) {
            int subarray = explore(arr,i);
            output[i] = subarray;
        }
        return output;
    }

    private static int explore (int [] arr, int index) {
        int subarray = 1;
        int leftIndex = index;
        // go to left
        while (leftIndex > 0 && arr[index] > arr[leftIndex -1]) {
            subarray++;
            leftIndex--;
        }

        // go right
        int rightIndex = index;
        while (rightIndex < arr.length-1 && arr[index] > arr[rightIndex +1]) {
            subarray++;
            rightIndex++;
        }
        return subarray;
    }

}
