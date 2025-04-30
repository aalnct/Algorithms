package OAOracle.year_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedListPQ {

    public static void main(String[] args) {
        ListNode list1 = createLinkedList(new int [] {1,4,5});
        ListNode list2 = createLinkedList(new int [] {1,3,4,});
        ListNode list3 = createLinkedList(new int [] {2,6});

        ListNode [] listNodes = {list1,list2,list3};

        ListNode result = mergeKSortedList(listNodes);

        while (result != null) {
            System.out.println(" --> " + result.val);
            result = result.next;
        }
    }

    static ListNode createLinkedList (int [] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    static ListNode mergeKSortedList (ListNode [] listNodes) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );


        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                minHeap.offer(listNode);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
