package leetcode.top_150;

public class MedianSortedArrays {

    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};

        System.out.println(findMedianSortedArray(nums1, nums2));
    }

    static double findMedianSortedArray (int [] nums1, int [] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0, k = 0;
        int [] merged = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }

        while (j < n) {
            merged[k++] = nums2[j++];
        }

        int length = m + n;

        if (length % 2 == 0) {
            return (merged[length/2 -1 + length % 2])/2.0;
        } else {
            return merged[length/2];
        }
    }
}
