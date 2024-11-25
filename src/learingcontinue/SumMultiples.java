package learingcontinue;

public class SumMultiples {

    public static void main(String[] args) {
        System.out.println(sumDivisible(7));
    }

    static int sumDivisible (int number) {
        int sum = 0 ;
        for (int i=1; i<=number; i++) {
            if (i % 3 == 0 || i % 5 ==0 || i % 7 ==0) {
                sum += i;
            }
        }
        return sum;
    }
}
