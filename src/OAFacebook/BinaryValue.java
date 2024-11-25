package OAFacebook;

public class BinaryValue {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String result = returnBinaryValue(a,b);

        System.out.println(result);
    }

    static String returnBinaryValue (String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >=0 || j >=0) {
            int sum = carry;

            if (i >=0) {
                sum += a.charAt(i)-'0';
                i--;
            }
            if (j >=0) {
                sum += b.charAt(j)-'0';
                j--;
            }

            sb.insert(0,sum%2);
            carry = sum/2;
        }

        if (carry > 0) {
            sb.insert(0,carry);
        }

        return sb.toString();
    }
}
