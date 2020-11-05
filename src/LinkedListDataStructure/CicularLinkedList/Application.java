package LinkedListDataStructure.CicularLinkedList;

/**
 * Created by AmitAgarwal on 5/23/19.
 */
public class Application {

    public static void main(String [] args){
        CicularLinkedList circular = new CicularLinkedList();
        circular.insertFirst(10);
        circular.insertFirst(90);
        circular.insertFirst(100);
        circular.insertFirst(50);


        circular.displayList();


        circular.addNodeAtEnd(8);

        circular.displayList();

    }

}
