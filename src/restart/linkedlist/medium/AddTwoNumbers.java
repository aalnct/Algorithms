package restart.linkedlist.medium;

import java.util.Properties;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1,l2);

        while (result != null) {
            System.out.println("Result :" + result.value);
            result = result.next;
        }
    }

    static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        while (l1 != null || l2 != null) {
         int sum = 0+ carry;

         if (l1 != null) {
             sum += l1.value;
             l1 = l1.next;
         }

         if (l2 != null) {
             sum += l2.value;
             l2 = l2.next;
         }

         carry = sum/10;
         sum = sum % 10;

         pointer.next = new ListNode(sum);
         pointer = pointer.next;
        }

        if (carry == 1) pointer.next = new ListNode(1);

        return result.next;
    }
}
