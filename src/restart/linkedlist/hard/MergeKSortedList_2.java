package restart.linkedlist.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode [] listNodes = {list1,list2,list3};

        ListNode current = mergeKSortedList(listNodes);
        while (current != null) {
            System.out.print(current.value + " . ");
            current = current.next;
        }

    }

    static ListNode mergeKSortedList(ListNode[] listNode) {
        if (listNode == null || listNode.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value)); // ascending order

        for (ListNode list : listNode) {
            if (list != null) {
                pq.offer(list); // so this will add all heads in the list
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minElement = pq.poll();
            current.next = minElement;
            current = current.next;


            if (minElement.next != null) {
                pq.offer(minElement.next);
            }
        }

        return dummy.next;
    }

}
