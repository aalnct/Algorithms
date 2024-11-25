package singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int value;
    ListNode next;

    public ListNode (int value) {
        this.value = value;
    }
}
public class RemoveDuplicate {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);

        ListNode r = removeDuplicate(node);

        while (r != null) {
            System.out.println(r.value);
            r = r.next;
        }
    }

    static ListNode removeDuplicate (ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        Set<Integer> seen = new HashSet<>();

        while (current != null) {
            if (seen.contains(current.value)) {
                previous.next = current.next;
                // System.out.println();
            } else {
                seen.add(current.value);
                previous = current;
                // System.out.println();
            }
            current =current.next;
        }
        return head;
    }
}
