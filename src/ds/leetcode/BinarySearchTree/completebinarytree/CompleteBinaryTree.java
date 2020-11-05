package ds.leetcode.BinarySearchTree.completebinarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AmitAgarwal on 6/3/20.
 */

public class CompleteBinaryTree {

    static class Node {
        public int data;
        public Node left;
        public Node right;


        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

        static boolean isComplete(Node root){

            boolean flag = false;

            if(root == null){
                return true; // null tree is complete binary tree
            }

            Queue<Node> queue = new LinkedList<>();

            queue.add(root);

            while(!queue.isEmpty()){
                Node tempNode = queue.remove();

                if(tempNode.left != null){
                    if(flag == true){
                        return false;
                    }

                    queue.add(tempNode.left);
                }
                else
                    flag = true;

                if (tempNode.right != null){
                        if(flag){
                            return false;
                        }
                        queue.add(tempNode.right);
                    }else {
                        flag = true;
                    }
            }

            return true;
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.right = new Node(6);

            if(isComplete(root)){
                System.out.println("complete binary tree");
            }else {
                System.out.println("not complete binary tree");
            }

            // Not a complete binary tree
            //      1
            //     / \
            //    2   3
            //   / \   \
            //  4   5   6
        }
    }
}
