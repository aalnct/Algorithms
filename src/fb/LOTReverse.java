package fb;

import java.util.*;

public class LOTReverse {


    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> result = reverseLevelOrder(root);
            Collections.reverse(result);
            result.forEach(System.out::println);
        }

        static List<List<Integer>> reverseLevelOrder (TreeNode root) {
            List<Integer> list = null;
            List<List<Integer>> result = new ArrayList<>();

            // for reverse operations, we can use Deque
            Deque<TreeNode> deque = new ArrayDeque();
            deque.add(root);
            while (!deque.isEmpty()) {
                list = new ArrayList<>();
                int size = deque.size();
                for (int i=0; i<size;i++) {
                    TreeNode node = deque.poll();
                    list.add(node.data);

                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }

}
