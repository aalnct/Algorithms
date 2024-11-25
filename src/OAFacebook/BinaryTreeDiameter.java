package OAFacebook;

class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BinaryTreeDiameter {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        //tree.right = new BinaryTree(3);
        //tree.left.left = new BinaryTree(4);
        //tree.left.right = new BinaryTree(5);

        // System.out.println(binaryTreeDiameter(tree));
        System.out.println(binaryTreeDiameter_2(tree));
    }

    /*static int binaryTreeDiameter (BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        int height = 0;

        int leftHeight = binaryTreeDiameter(tree.left);
        int rightHeight = binaryTreeDiameter(tree.right);

        height = Math.max(leftHeight,rightHeight) + 1;

        return height;
    }*/

    static int binaryTreeDiameter_2(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        // calculate height of left and right subtree

        int leftHeight = calculateHeight(tree.left);
        int rightHeight = calculateHeight(tree.right);

        // calculate diameter , you need to consider three cases
        // 1. diameter through root
        // 2. diameter in the left subtree
        // 3. diameter in the right subtree

        int diameterThroughRoot = leftHeight + rightHeight;
        int leftDiameter = binaryTreeDiameter_2(tree.left);
        int rightDiameter = binaryTreeDiameter_2(tree.right);

        return Math.max(diameterThroughRoot, Math.max(leftDiameter,rightDiameter));
    }

    static int calculateHeight(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        int left = calculateHeight(tree.left);
        int right = calculateHeight(tree.right);

        return Math.max(left,right)+1;
    }
}
