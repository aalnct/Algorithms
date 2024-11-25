package restart.array.advance;

// Find Median of two sorted arrays
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    static double findMedianSortedArrays (int [] nums1, int []nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2,nums1); // making sure that length of nums1 is always less than num2 length
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m; // we are running binary sort on nums1 (i.e. always on smaller array)

        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (m + n + 1)/2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((m+n) % 2 == 0) {
                    return ((double)  Math.max(maxX,maxY) + Math.min(minX, minY))/2;
                } else {
                    return Math.max(maxX,maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted");
    }
}
