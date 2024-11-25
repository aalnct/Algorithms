package OAFacebook.repractice;

class ListNode {
    int data;
    ListNode next;

    public ListNode (int data) {
        this.data = data;
    }
}
public class MergeWithOutDuplicate {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);

        ListNode result = mergeWithoutDuplicate(l1,l2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    static ListNode mergeWithoutDuplicate (ListNode l1, ListNode l2) {
        ListNode mergedNode = new ListNode(-1);
        ListNode current =mergedNode;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                if (current.data != l1.data) {
                    current.next = l1;
                    current = l1;
                }
                l1 = l1.next;
            } else if (l1.data > l2.data) {
                if (current.data != l2.data) {
                    current.next = l2;
                    current = l2;
                }
                l2 = l2.next;
            } else {
                if (current.data != l1.data) {
                    current.next = l1;
                    current = l1;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            if (current.data != l1.data) {
                current.next = l1;
                current = l1;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (current.data != l2.data) {
                current.next = l2;
                current = l2;
            }
            l2 = l2.next;
        }

        return mergedNode.next;
    }
}
