package fb;

import java.util.Stack;

public class InsertAndPrintBST {

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Tree node = new Tree(4);
        node.left = new Tree(2);
        node.right = new Tree(7);
        node.left.left = new Tree(1);
        node.left.right = new Tree(3);

        insert(node,5);
    }

    static boolean insert (Tree root, int data) {
        Tree newNode = new Tree(5);
        Tree current = root;
        Tree prev;
        if (root == null) {
            root = newNode;
        } else {
            while (true) {
                prev = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        prev.left = newNode;
                        System.out.println("Printing new Tree with left level insertion");
                        printBST (root);
                        return true;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        prev.right = newNode;
                        System.out.println("Printing new Tree with right level insertion");
                        printBST (root);
                        return true;
                    }
                }
            }
        }
        printBST (root);
        return false;
    }

    static void printBST (Tree tree) {
        if (tree == null) {
            return;
        }

        Stack<Tree> stack = new Stack<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            Tree t = stack.pop();
            System.out.print(t.data + " ");
            if (t.left != null) {
                stack.add(t.left);
            }
            if (t.right != null) {
                stack.add(t.right);
            }
        }
    }

}
