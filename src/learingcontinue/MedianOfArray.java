package learingcontinue;

public class MedianOfArray {

    public static void main(String[] args) {
        int nums1 []  = new int [] {1,3};
        int nums2 [] = new int [] {2};

        double median = findMedian(nums1, nums2);
        System.out.println(median);
    }

    static double findMedian(int [] nums1, int [] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int [] merged = new int[m + n];

        int i = 0; // pointer for array 1
        int j = 0; // pointer for array 2
        int k = 0; // pointer for merged array

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // copy the remaining element from array 1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // copy the remaining element from array 2
        while (j < n) {
            merged[k++] = nums2[i++];
        }


        // calculate median based on length
        int length = m + n;

        if (length % 2 == 0) {
            return (merged[length/ 2-1] + merged[length/2])/2.0;
        } else {
            return merged[length / 2];
        }
    }

}
