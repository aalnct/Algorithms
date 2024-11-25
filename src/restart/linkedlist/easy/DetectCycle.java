package restart.linkedlist.easy;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(2);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(-4);
        // create cycle
        list.next.next.next.next = list.next;

        System.out.println(detectCycle(list));
    }

    static boolean detectCycle (ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println(slow.value + ", " + fast.value);
                return true;
            }
        }
        return false;
    }


}
