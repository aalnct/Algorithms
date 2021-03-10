package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static void main(String[] args) {
        PairSum pair = new PairSum();
        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int n = pair.numberOfWays(arr_2,k_2);
        System.out.println(n);

        n = pair.numberOfWaysBinary(arr_2,k_2);
        System.out.println(n);
    }

    private int numberOfWays (int [] array, int k) {
        int n = array.length;
        int total = 0;
        for (int i=0;i<=n-1;) {
            for (int j = i+1; j<= n-1; j++) {
                if (array[i] + array[j] == k) {
                    total = total+1;
                }
            }
            i++;
        }
        return total;
    }

    private int numberOfWaysBinary (int [] array, int k) {
        int total = 0;
        boolean flag;
        int n = array.length;
        Arrays.sort(array);
        for (int i=0;i < n; i++) {
            flag = binarySearch (array,k-array[i]);
            if (flag) {
                total++;
            }
        }
        return total;
    }

    private boolean binarySearch(int[] array, int target) {
        boolean flag = false;
        int p = 0; // start index
        int q = array.length-1; // end index
        while (p<=q) {
            int pivot = (p+q)/2;
            if (target == array[pivot]) {
                flag = true;
            }else if (array[pivot] > target ) {
                q = pivot-1;
            }else if (array[pivot] < target){
                p = pivot+1;
            }
        }
        return flag;
    }

    private int pairSum (int [] arr, int k) {
        int total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < arr.length;i++) {
            int find = k-arr[i];
            if (map.containsKey(find)) {
                total++;
            }
        }
        return total;
    }
}
