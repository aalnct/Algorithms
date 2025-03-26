package OAFacebook;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        System.out.println(multiplyStrings(num1,num2));
    }

    static String multiplyStrings (String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int [] result = new int[m+n];

        for (int i=m-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j)- '0');
                int sum = product + result[i+j+1];
                result[i+j] += sum/10; // carry
                result[i+j+1] = sum%10; // current digit
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}