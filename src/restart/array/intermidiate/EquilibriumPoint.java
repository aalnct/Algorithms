package restart.array.intermidiate;

public class EquilibriumPoint {

    public static void main(String[] args) {
        int [] arr = {1,2,0,3};
        System.out.println(findEquilibriumPoint(arr));
    }

    static int findEquilibriumPoint (int [] arr) {
        if (arr == null || arr.length == 0) return -1;

        int totalSum = 0;
        for (int n : arr) {
            totalSum +=n;
        }

        int leftSum = 0 ;
        for (int i=0; i < arr.length; i++) {
            //  checking if right sum == left sum
            if (leftSum == totalSum - leftSum  - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
