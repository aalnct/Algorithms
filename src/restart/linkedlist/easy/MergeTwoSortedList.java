package restart.linkedlist.easy;

public class MergeTwoSortedList {


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = mergeSortedList(list1,list2);

        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
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

        prev.next = list1 != null ? list1 : list2;

        return prevNode.next;
    }
}
