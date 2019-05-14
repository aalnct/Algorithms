/**
 * Created by AmitAgarwal on 11/21/18.
 */
public class ArraySmallestSub {
    public static void main(String [] args){
        int length = findSmallestSubArray();
        System.out.print(length);


        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        int n1 = arr1.length;
        int result  = smallestSumWithSum(arr1,n1,x);
        if(result == n1+1){
            System.out.print("not possible");
        }else{
            System.out.print( "{}{}{} result {}{}{}" + result);
        }
    }

    private static int findSmallestSubArray(){
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 20;

        //sliding window approach
        //stores the current window sum
        int windowSum = 0;

        //stores the result
        int length = Integer.MAX_VALUE;

        //windows starting index
        int left = 0;

        //sliding window left...right
        for(int right = 0; right< array.length;right++){
            windowSum +=array[right];
            //to handle negative
            if(windowSum <=0){
                left = right;
                windowSum = 0;
            }
            while(windowSum > sum && left <= right){
                //update length if current window length is less than found so far
                length = Integer.min(length,right-left+1);
                windowSum -=array[left];
                left++;
            }
        }
        return length;
    }

    private static int smallestSumWithSum(int[] arr1,int n, int x){
        //smallest sub-array with length n+1
        int min_length = n+1;
        //pick every element as starting point
        for(int start = 0; start < arr1.length;start++){
            //initialize current sum with starting element
            int curr_sum =arr1[start];
            if(curr_sum > x){
                return 1;
            }

            for(int end = start+1;end < n; end++){
                //add last element to current sum
                curr_sum +=arr1[end];

                if(curr_sum > x && (end-start+1) < min_length){
                    min_length = end-start+1;
                }
            }
        }

        return min_length;
    }
}
