package fb;

public class SumOddLengthSubArray {

    public static void main(String[] args) {
        int [] array = new int [] {1,4,2,5,3};
        int sum = sumOfSubArrayOfOddLength(array);
        System.out.println(sum);
    }

    static int sumOfSubArrayOfOddLength (int [] array) {
        int total = 0;
        for (int i=0; i <array.length;i++) {
            int sum = 0;
            sum +=array[i];
            total += array[i];

            int j = i;

            while (j+2 < array.length) {
                sum += array[j+1] + array[j+2];
                total +=sum;
                j+=2;
            }
        }
        return total;
    }
}
