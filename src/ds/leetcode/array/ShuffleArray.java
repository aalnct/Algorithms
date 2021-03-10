package ds.leetcode.array;

public class ShuffleArray {
    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,4,4,3,2,1} ;
        int n = 4;
        // suffleArray (array,n);
        int [] a = shuffleArray (array,n);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void suffleArray (int [] array, int n) {
        array = new int [] {1,2,3,4,4,3,2,1} ;
        n = 4;
        int [] arrayX = new int[n];
        int [] arrayY = new int[array.length];
        int [] tempArray = new int[array.length];

        for (int i = 0; i < n ; i++) {
            arrayX [i] = array[i]; // got x values
        }

        for (int i = n; i< array.length; i++) {
            arrayY[i] = array[i]; // got y values
        }

        // alternate b/w two arrays and create a new array

        for (int i = 0; i< array.length; i++) {
            tempArray [i] = arrayX[i];
            for (int j = i+1; j < array.length; j++) {
                tempArray[j] = arrayY[i];
                break;
            }
        }

        for (int a : tempArray) {
            System.out.println(tempArray);
        }
    }

    private static int[] shuffleArray (int [] array, int n) {
        int [] arr = new int[n*2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            arr[j++] = array[i];
            arr[j++] = array[i+n];
        }

        return arr;
    }
}
