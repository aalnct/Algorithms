package OAGoogle.array;

public class AddTwoNumbers {

    public static void main(String[] args) {
        String nums1 = "5436";
        String nums2 = "4578";

        System.out.println(addStrings(nums1,nums2));
    }

    static String addStrings(String nums1, String nums2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = nums1.length()-1;
        int j = nums2.length()-1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >=0) ? nums1.charAt(i--) - '0' : 0;
            int digit2 = (j >=0) ? nums2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry; // 6 + 8 + 0 --> 14 // 3 + 7 + 1 // 4 + 5 + 1 // 5 + 4 + 1

            result.insert(0, sum % 10); // 12 % 10 --> 4 // 11 % 10 --> 1 // 10 % 10 --> 0 // 10 % 10 --> 0
            carry = sum/10; // 1 // 1 // 1 // 1 --> 14100 --> 14100
        }

        return result.toString();

    }
}
