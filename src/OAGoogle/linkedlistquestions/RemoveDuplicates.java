package OAGoogle.linkedlistquestions;

import java.util.HashSet;
import java.util.Set;

class ListNode1 {


    int value;
    ListNode1 next;

    public ListNode1 (int value) {
        this.value = value;
    }

}
public class RemoveDuplicates {

    public static void main (String [] args) {
        ListNode1 node = new ListNode1(1);
        node.next= new ListNode1(2);
        node.next.next = new ListNode1(3);
        node.next.next.next = new ListNode1(3);
        node.next.next.next.next = new ListNode1(4);

        ListNode1 duplicate = removeDuplicate_2(node);

        while (duplicate != null) {
            System.out.println(duplicate.value);
            duplicate = duplicate.next;
        }
    }

    static ListNode1 removeDuplicate (ListNode1 node) {
        ListNode1 current = node;

        while (current.next != null) {
            if (current == current.next) {
                current.next = current.next.next;
            }

            current =current.next;
        }

        return current.next;
    }

    // using hashset apporach ...

    static ListNode1 removeDuplicate_2 (ListNode1 head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        ListNode1 current = head;

        set.add(current.value); // 1

        while (current.next != null) { // 2 //3 // 3 //4
            if (set.contains(current.next.value)) { // false, false, true
                current.next = current.next.next; // 4
            } else {
                set.add(current.next.value); // 1, 2, 3
                current = current.next; // --> 2 --> 3
            }
        }
        return head;
    }

}
