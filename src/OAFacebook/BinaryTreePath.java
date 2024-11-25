package OAFacebook;

import java.util.ArrayList;
import java.util.List;

class BinaryTree2 {
    int data;
    BinaryTree2 left;
    BinaryTree2 right;

    public BinaryTree2 (int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BinaryTreePath {

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2(1);
        tree.left = new BinaryTree2(2);
        tree.right = new BinaryTree2(3);
        tree.left.right = new BinaryTree2(5);

        List<String> result = printAllPath(tree);
        result.forEach(System.out::println);
    }

    static List<String> printAllPath(BinaryTree2 tree) {
        List<String> path = new ArrayList<>();
        if (tree == null) {
            new ArrayList<>();
        } else {
            binaryTreeHelper(tree, "" , path);
        }
        return path;
    }

    static void binaryTreeHelper (BinaryTree2 tree, String makePath, List<String> path) {
        if (tree == null) {
            return;
        }

        makePath +=tree.data;

        if (tree.left == null && tree.right == null) {
            path.add(makePath);
        } else {
            makePath +="->";
            binaryTreeHelper(tree.left,makePath,path);
            binaryTreeHelper(tree.right,makePath,path);
        }
    }

}
