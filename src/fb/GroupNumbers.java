package fb;

public class GroupNumbers {

    public static void main(String[] args) {
        int [] array = new int [] {3,1,2,5};
        array = solve(array);

        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }

    static int[] solve (int [] arr) {
        int i = 0; // left
        int j = arr.length-1; // right
        while (i < j) {
            if (arr[i] % 2 == 0) {
                i++;
            }else {
                swapElements(arr,i,j);
                j--;
            }
        }
        return arr;
    }

    static void swapElements (int[] arr, int i, int j) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
