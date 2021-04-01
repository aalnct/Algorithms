package fb;

import java.util.*;

public class LOTBFS {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrderTraversal(root);
        Collections.reverse(result);
        result.forEach(System.out::println);
    }

    static List<List<Integer>> levelOrderTraversal (TreeNode root) {
        List<Integer> list;
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);

        while (!s.isEmpty()) {
            list = new ArrayList<>();
            int size = s.size();
            for (int i=0; i < size;i++) {
                TreeNode node = s.poll();
                list.add(node.data);
                if (node.left != null) {
                    s.add(node.left);
                }
                if (node.right !=null) {
                    s.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
