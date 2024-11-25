package OAFacebook.repractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeUniValue {

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(5);
        tree.left = new BinaryTree1(1);
        tree.right = new BinaryTree1(5);
        tree.left.left = new BinaryTree1(5);
        tree.left.right = new BinaryTree1(5);
        tree.right.right = new BinaryTree1(5);

        int count = countUniValue_2(tree);
        System.out.println(count);
    }

    static int countUniValue (BinaryTree1 tree) {
        Map<Integer,Integer> countMap = new HashMap<>();
        isUniValue(tree,countMap);
        return countMap.getOrDefault(tree.data,0);
    }
    private static boolean isUniValue(BinaryTree1 tree, Map<Integer,Integer> countMap) {
        if (tree == null) {
            return true;
        }

        boolean leftUniValue = isUniValue(tree.left,countMap);
        boolean rightUniValue = isUniValue(tree.right,countMap);

        if (leftUniValue && rightUniValue && (tree.left == null || tree.left.data == tree.data)
        && (tree.right == null || tree.right.data == tree.data)) {
            countMap.put(tree.data, countMap.getOrDefault(tree.data,0)+1);
            return true;
        }
        return false;
    }

    // BFS apporach - Level Order Traversal

    // class to represents the nodes
    // fun to initialize the count, and using level order traversal to count the univalue
    // compare value at each level and if they are same, increment the count
    // result is the count

    private static int countUniValue_2(BinaryTree1 root) {
        if (root == null) {
            return 0;
        }
        int[] count = {0};

        Queue<BinaryTree1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTree1 node = queue.poll();

            if (isUniValue_2(node)) {
                count[0]++;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count[0];
    }

    private static boolean isUniValue_2(BinaryTree1 node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.left.data != node.data) {
            return false;
        }

        if (node.right != null && node.right.data != node.data) {
            return false;
        }

        return isUniValue_2(node.left) && isUniValue_2(node.right);
    }
}
