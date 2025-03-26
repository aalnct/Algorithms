package restart.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class BuildBalanceBST {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.right = new TreeNode1(2);
        root.right.right = new TreeNode1(3);
        root.right.right.right = new TreeNode1(4);

        TreeNode1 balance = balanceBST(root);

        print(balance);
    }

    private static void print (TreeNode1 balance) {
        if (balance == null) {
            return;
        }
        print(balance.left);
        System.out.print(balance.value + " ");
        print(balance.right);
    }

    private static TreeNode1 balanceBST (TreeNode1 root) {
        List<TreeNode1> nodes = new ArrayList<>();
        inOrder(root,nodes);

        return buildBalanceBST (nodes, 0,nodes.size()-1);
    }

    private static void inOrder (TreeNode1 root, List<TreeNode1> nodes) {
        if (root == null) return;
        inOrder(root.left,nodes);
        nodes.add(root);
        inOrder(root.right,nodes);
    }

    private static TreeNode1 buildBalanceBST (List<TreeNode1> nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode1 root = nodes.get(mid);

        root.left = buildBalanceBST(nodes,left, mid-1);
        root.right = buildBalanceBST(nodes, mid+1,right);

        return root;
    }
}
