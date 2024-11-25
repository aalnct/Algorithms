package learingcontinue;


import java.util.List;

class ListNode {
    int value;
    ListNode next;
    ListNode () {

    }
    ListNode (int value) {
        this.value = value;
    }

    ListNode (int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
public class RemoveNNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        
    }


    static ListNode removeNthNode (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;


        for (int i=1; i <= n+1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy;


    }

}
