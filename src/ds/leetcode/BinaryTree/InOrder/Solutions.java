package ds.leetcode.BinaryTree.InOrder;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class Solutions {
    public static void main(String[] args) {
        InOrderBT bt = new InOrderBT();
        bt.root = new Node(1);

        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        System.out.println("InOrder Traversal");
        bt.printInOrder();
    }
}
