package restart.tree.medium;

import java.util.ArrayList;
import java.util.List;

class PathSumTree {
    int val;

    PathSumTree left;
    PathSumTree right;

    public PathSumTree (int val) {
        this.val = val;
    }
}

public class PathSumII {
    public static void main(String[] args) {
        PathSumTree root = new PathSumTree(5);

        root.left = new PathSumTree(4);
        root.right = new PathSumTree(8);
        root.left.left = new PathSumTree(11);
        root.left.left.left = new PathSumTree(7);
        root.left.left.right = new PathSumTree(2);
        root.right.left = new PathSumTree(13);
        root.right.right = new PathSumTree(4);
        root.right.right.right = new PathSumTree(1);
        root.right.right.left = new PathSumTree(5);

        List<List<Integer>> result = pathSumII(root,22);
        for (List<Integer> res : result) {
            res.forEach(System.out::print);
        }
    }

    static List<List<Integer>> pathSumII (PathSumTree root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
         return result;
        }

        List<Integer> path = new ArrayList<>();

        dfs(root,target,path,result);
        return result;
    }

    static void dfs (PathSumTree node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);

        if (node.left == null && node.right == null && node.val == target) {
            result.add(new ArrayList<>(path)); // adding a copy of path sum
        }
        else {
            dfs(node.left, target-node.val, path,result);
            dfs(node.right, target-node.val, path,result);
        }
        path.remove(path.size()-1);
    }
}
