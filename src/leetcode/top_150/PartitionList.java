package leetcode.top_150;

/*
partition list based on the value of x
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        ListNode afterPartition = partitionList(head,x);

        while (afterPartition != null) {
            System.out.print(afterPartition.value + " ");
            afterPartition = afterPartition.next;
        }
    }

    private static ListNode partitionList(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;

        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;

        while (head != null) {
            if (head.value < x) {
                lessTail.next = head;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }

        lessTail.next = null;
        greaterTail.next = null;

        // connect both list
        lessTail.next = greaterHead.next;

        return lessHead.next;
    }
}
