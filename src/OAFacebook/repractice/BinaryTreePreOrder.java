package OAFacebook.repractice;
class BinaryTree1 {
    int data;
    BinaryTree1 left;
    BinaryTree1 right;

    public BinaryTree1 (int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BinaryTreePreOrder {

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(10);
        tree.left = new BinaryTree1(5);
        tree.right = new BinaryTree1(11);
        tree.left.left = new BinaryTree1(4);
        tree.left.right = new BinaryTree1(6);

        System.out.println("PreOrder first");
        preOrder(tree);

        System.out.println("  ");
        System.out.println("PostOrder second");
        postOrder(tree);

        System.out.println( " ");
        System.out.println("Inorder Last");
        inOrder(tree);
    }

    // preOrder --> root, left, right
    static void preOrder(BinaryTree1 tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.data + " .. ");
        preOrder(tree.left);
        preOrder(tree.right);
    }
    // postOrder -- left, right, root
    static void postOrder (BinaryTree1 tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.print(tree.data + " .. ");
    }

    // inOrder -- left, root, right
    static void inOrder (BinaryTree1 tree) {
        if (tree ==  null) {
            return;
        }

        inOrder(tree.left);
        System.out.print(tree.data + " .. ");
        inOrder(tree.right);
    }
}
