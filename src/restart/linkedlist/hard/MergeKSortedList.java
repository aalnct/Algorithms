package restart.linkedlist.hard;


import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int value;
    ListNode next;

    public ListNode (int value) {
        this.value = value;
    }
}
public class MergeKSortedList {

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

    private static ListNode mergeKSortedList (ListNode [] head) {
        if (head == null || head.length == 0) {
            return null;
        }
        // we are going to use Priority Queue to get the minimum element from the
        // top of it, so that we can start creating a result list with minimum elements at top

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        // start adding the heads to Linked List into Priority Queue
        for (ListNode list : head) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // now take the minimum elements from top of list and add them into priority queue
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) { // head should already be in priority queue
            ListNode minElement = pq.poll();
            current.next = minElement;
            current = current.next;

            // if priority queue has next element present add that to list
            if (minElement.next != null) {
                pq.offer(minElement.next);
            }
        }

        return dummy.next;
    }

}
