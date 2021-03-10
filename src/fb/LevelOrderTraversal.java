package fb;

import java.util.*;

public class LevelOrderTraversal {

    static class  TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>>  l = printLevelOrder(node);
        for (int i = 0 ; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

    }

    static List<List<Integer>> printLevelOrder(TreeNode node) {
        List<Integer> list;
        List<List<Integer>> result  = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i < size;i++) {
                TreeNode n = queue.poll();
                list.add(n.data);

                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right!=null) {
                    queue.add(n.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
