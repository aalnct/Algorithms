package restart.linkedlist.medium;

public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode num1 = new ListNode(3);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(2);

        ListNode num2 = new ListNode(4);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(5);

        ListNode result = addTwoNumbers(num1,num2);
        while (result != null) {
            System.out.print(result.value);
            result = result.next;
        }
    }
    static ListNode addTwoNumbers (ListNode num1, ListNode num2) {
        int sum = 0;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode pointer = result;


        while (num1 != null || num2 != null) {

            sum = 0 + carry;

            if (num1 != null) {
                sum = sum + num1.value;
                num1 = num1.next;
            }

            if (num2 != null) {
                sum = sum + num2.value;
                num2 = num2.next;
            }
            carry = sum/10;
            sum = sum % 10;

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        if (carry > 0) {
            pointer.next = new ListNode(1);
        }

        return result.next;
    }

}
