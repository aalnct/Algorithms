package linkedlist;

class ListNode1 {
    int data;
    ListNode1 next;

    public ListNode1(int data) {
        this.data = data;
        this.next = null;
    }
}
public class BinaryListToInteger {
    public static void main(String[] args) {
        ListNode1 node = new ListNode1(1);
        node.next = new ListNode1(0);
        node.next.next = new ListNode1(1);

        System.out.println(getDecimalValue(node));
    }

    private static int getDecimalValue(ListNode1 head) {

        StringBuilder builder = new StringBuilder();

        while(head != null) {
            builder.append(head.data);
            head = head.next;
        }

        return Integer.parseInt(builder.toString(), 2);
    }
}
