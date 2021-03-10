package ds.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int a = 19;
        System.out.println(a%10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 0 to exit");
        int n = scanner.nextInt();
        while (n!=0) {
            System.out.println(isHappy(n) ? 1:0);
            System.out.println("Enter number 0 to exit");
            n = scanner.nextInt();
        }
    }

    private static boolean isHappy (int n) {
        long startTimeInMillis = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        int computed;
        do {
         computed = 0;
         set.add(n);
         while (n > 0) {
             computed += square(n%10);
             n /= 10;
         }if (set.contains(computed)) break;
            n=computed;
        }while (computed != 1);
        long endTimeInMillis = System.currentTimeMillis();
        System.out.println(endTimeInMillis - startTimeInMillis);
        return computed==1;
    }

    private static int square (int i){
        return i*i;
    }
}
