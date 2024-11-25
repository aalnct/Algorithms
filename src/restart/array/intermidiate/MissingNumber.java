package restart.array.intermidiate;

public class MissingNumber {

    public static void main(String[] args) {
        int [] array = {3,0,1};

        System.out.println(missingNumber(array));
    }

    static int missingNumber (int [] array) {
        int expectedSum = array.length * (array.length + 1)/2;
        int actualSum = 0;

        for (int arr : array) {
            actualSum +=arr;
        }

        int missing = expectedSum - actualSum;
        return missing;
    }
}
