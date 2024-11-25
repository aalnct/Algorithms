package leetcode.top_150;

/**
 * Add two numbers in a linkedlist
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.value: 0;
            int y = (l2 != null) ? l2.value: 0;

            int sum  = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
