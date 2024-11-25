package OAGoogle.linkedlistquestions;

import java.util.List;


class ListNode {
    int value;
    ListNode next;

    public ListNode (int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode (int value) {
        this.value = value;
    }
}
public class MergeSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = mergeSortedList(list1, list2);

        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
        // System.out.println(listNode.value);
    }

    private static ListNode mergeSortedList (ListNode list1, ListNode list2) {
        ListNode prevNode = new ListNode(-1);
        ListNode prev = prevNode;

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // there is a chance that one node list is greater than the other
        prev.next = list1 == null ? list2 : list1;

        return prevNode.next;
    }
}
