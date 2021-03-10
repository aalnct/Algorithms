package fb;

import java.util.ArrayList;
import java.util.List;

public class LeafPathSum2Working2 {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree (int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    static List<List<Integer>>  pathSum (BinaryTree root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs (root,targetSum,list,result);
        return result;
    }

    static void dfs (BinaryTree root, int targetSum, List<Integer> list,
                     List<List<Integer>> result) {
        if (root == null) return;

        if (root.left == null && root.right == null && targetSum == root.value) {
            list.add(root.value);
            result.add(list);
            list.remove(list.size() - 1);
        }

        list.add(root.value);
        dfs(root.left, targetSum - root.value, list, result);
        dfs(root.right, targetSum - root.value, list, result);
        list.remove(list.size() - 1);

        return;
    }
}
