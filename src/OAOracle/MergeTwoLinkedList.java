package OAOracle;

class Merge {
    public int value;
    public Merge next;

    public Merge (int value) {
        this.value = value;
    }
}
public class MergeTwoLinkedList {

    public static void main(String[] args) {
        Merge list1 = new Merge(1);
        list1.next = new Merge(2);
        list1.next.next = new Merge(4);

        Merge list2 = new Merge(1);
        list2.next = new Merge(3);
        list2.next.next = new Merge(4);

        Merge listNode = mergeLinkedList(list1, list2);

        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
    }

    static Merge mergeLinkedList (Merge list1, Merge list2) {
        Merge node = new Merge(-1);
        Merge prevNode = node;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                prevNode.next = list1;
                list1 = list1.next;
            } else {
                prevNode.next = list2;
                list2 = list2.next;
            }
            prevNode = prevNode.next;
        }
        // when one list is greater than other

        prevNode.next = list1 == null ? list2 : list1;

        return node.next;
    }
}
