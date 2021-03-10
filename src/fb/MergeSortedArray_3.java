package fb;

public class MergeSortedArray_3 {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};

        // merge(nums1,nums2);
        merge1(nums1, nums1.length, nums2, nums2.length);
    }

    public static void merge(int [] nums1, int nums2[]) {
        // we will take length of smaller array, since our condition is to copy
        // smaller array into larger one
        int index1 = nums2.length-1;
        int index2 = nums2.length-1;
        int pointer = nums1.length-1;

        /**
         *
         *
         * 0
         * [1]
         * 1
         *
         * [2,0]
         * 1
         * [1]
         * 1
         *
         *
         */

        if (nums1.length !=0 && nums2.length!=0) {
            while (index1 >=0 && index2 >=0) {
                if (nums1[index1] >= nums2[index2]) {
                    // we will start from the end of the array
                    nums1[pointer] = nums1[index1];
                    pointer--;
                    index1--;
                } else if (nums1[index1] < nums2[index2]) {
                    nums1[pointer] = nums2[index2];
                    pointer--;
                    index2--;
                } // |1|2|2|3|5|6
            }

            while (index2 >= 0) {
                nums1[pointer] = nums2[index2];
                pointer--;
                index1--;
            }

            while (index1 >= 0){
                nums1[pointer] = nums1[index1];
                pointer--;
                index1--;
            }
        }

        for (int i: nums1) {
            System.out.println(i);
        }
    }


    static void merge(int[] nums1, int m, int [] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1; // pointer index where we store value after comparision

        while (i>=0 && j>=0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
                // k--;
                // j--;
            }
        }

        while (j >= 0) {
            nums1[j] = nums2[j--];
            //nums1[k--] = nums2[j--];
            // k--;
            // j--;
        }

        for (int ii : nums1) {
            System.out.println(ii);
        }
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (i>=0 && j>=0) {
            nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        while (i!=-1 && j>=0)
            nums1[j] = nums2[j--];
    }
}
