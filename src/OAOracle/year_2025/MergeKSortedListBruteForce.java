package OAOracle.year_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
    }
}

// understanding the time complexity and space complexity of the brute force approach

// Time Complexity ::
    // concatenating all elements :: O(N)
    // sorting all combined arrays :: O(n log n)
    // overall :: O(n log n)

// space complexity
    // for using array list :: O(N)

public class MergeKSortedListBruteForce {

    public static void main(String[] args) {
        ListNode list1 = createLinkedList(new int [] {1,4,5});
        ListNode list2 = createLinkedList(new int [] {1,3,4,});
        ListNode list3 = createLinkedList(new int [] {2,6});

        ListNode [] listNodes = {list1,list2,list3};

        ListNode result = mergeListNodeBruteForce(listNodes);

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

    static ListNode mergeListNodeBruteForce (ListNode [] listNodes) {
        List<Integer> values = new ArrayList<>();

        for (ListNode listNode : listNodes) {
            ListNode current = listNode;
            while (current != null) {
                values.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(values);

        // will create a new linked list and return it ...

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}

