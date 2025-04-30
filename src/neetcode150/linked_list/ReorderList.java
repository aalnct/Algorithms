package neetcode150.linked_list;

public class ReorderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        // 1 -- 5 -- 2 -- 4 --3 answer
        // print(l1);
        reOrderList(l1);
        print(l1);
    }

    static void print (ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    static void reOrderList (ListNode head) {
        // find the middle element
        // reverse the second half
        // merge alternatively both half

       ListNode slow =  head;
       ListNode fast = head;

       while (fast.next != null && fast.next.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }

       // reversing the second half

       ListNode second = slow.next;
       slow.next = null; // breaking the connection b/w both half
        ListNode prev = null;

        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        second = prev;

        // merging both listnodes alternatively
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first =  t1;
            second = t2;
        }
    }
}
