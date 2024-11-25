package learingcontinue;


import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {
    int value;
    BinaryTreeInorderTraversal left;
    BinaryTreeInorderTraversal right;


    public BinaryTreeInorderTraversal (int value) {
        this.value = value;
    }
}
public class InorderTraversal {


    public static List<Integer> inOrderTraversal (BinaryTreeInorderTraversal root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root,inOrder);
        return inOrder;
    }

    public static void inOrderTraversal(BinaryTreeInorderTraversal root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.value);
        inOrderTraversal(root.right,inOrder);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal node = new BinaryTreeInorderTraversal(1);
        node.left = new BinaryTreeInorderTraversal(2);
        node.right = new BinaryTreeInorderTraversal(3);
        node.left.left = new BinaryTreeInorderTraversal(4);
        node.left.right = new BinaryTreeInorderTraversal(5);
        node.right.left = new BinaryTreeInorderTraversal(6);
        node.right.right = new BinaryTreeInorderTraversal(7);

        List<Integer> inOrder = inOrderTraversal(node);
        // inOrder.stream().forEach(s -> System.out.println(s));
        System.out.println(inOrder);
    }
}
