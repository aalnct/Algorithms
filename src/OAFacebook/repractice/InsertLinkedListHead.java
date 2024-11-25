package OAFacebook.repractice;

class SinglyLinkedList {
    int data;
    SinglyLinkedList next;

    public SinglyLinkedList (int data) {
        this.data = data;
    }
}
public class InsertLinkedListHead {

    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList(321);
        head = returnHead(head,984);
        head = returnHead(head,498);
        printLinkedList(head);
    }

    static SinglyLinkedList returnHead(SinglyLinkedList head,int data) {
        SinglyLinkedList newNode = new SinglyLinkedList(data);
        if (head == null) {
            return newNode;
        } else {
            newNode.next = head;
            return newNode;
        }
    }

    static void printLinkedList (SinglyLinkedList head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
