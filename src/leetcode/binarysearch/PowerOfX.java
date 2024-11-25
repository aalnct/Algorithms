package leetcode.binarysearch;

public class PowerOfX {

    public static void main(String[] args) {
        double x = 2;
        int n = 10;

        System.out.println(powerOfX(x,n));
    }

    private static double powerOfX(double x, int n) {
        int count = 0;
        double n1 = n;
        if (n1 == 0) {
            return 1;
        } else if (n1 < 0) {
            x = 1/x;
            n1 = -n1;
        }

        double result = 1;
        double currentPower = x;

        while (n1 > 0) {
            count++;
            if (n1 % 2 ==1) {
                result *=currentPower;
            }
            currentPower *=currentPower;
            n1 = n1/2;
        }
        System.out.println(count);
        return result;
    }
}
