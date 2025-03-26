package restart.string.intermidiate;

// find lowest index in array where
// index == arr[index]
public class FindLowestIndex {

    public static void main(String[] args) {
        int [] arr = {-5, -2, 0, 3, 4, 5, 9};
        System.out.println(lowestIndex(arr));
    }

    static int lowestIndex (int [] arr) {
        int min = -1;
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {

            int mid = left + (right - left)/2;

            if (arr[mid] == mid) {
                min = mid;
                right = mid -1 ; // since we are only interested in lowest index
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }

}
