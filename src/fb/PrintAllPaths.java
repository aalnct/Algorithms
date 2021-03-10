package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPaths {

    static class NodeTree {
        int data;
        NodeTree left;
        NodeTree right;

        NodeTree (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        NodeTree root = new NodeTree(10);
        root.left = new NodeTree(8);
        root.right = new NodeTree(12);
        root.left.left = new NodeTree(7);
        root.left.right = new NodeTree(9);
        root.right.left = new NodeTree(11);
        root.right.right = new NodeTree(15);

        int[] array = new int[1000];
        int length = 0;
        // printAllPaths(root,array,length);

        List<String> list = binaryTreePaths(root);

        for (String s : list) {
            System.out.println(s);
        }
    }

    static void printAllPaths (NodeTree root, int[] array, int length) {
        if (root == null) {
            return;
        }

        array[length] = root.data;
        length++;
        if (root.left == null || root.right == null) {
            print(array,length);
        }
        printAllPaths(root.left,array,length);
        printAllPaths(root.right,array,length);
    }

    static void print (int[] array, int length) {
        for (int i= 0; i < length;i++) {
            System.out.println(array[i] + "->");
        }
    }

    static List<String> binaryTreePaths(NodeTree root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        helper(root, "" , list);
        return list;
    }

    static void helper(NodeTree root, String paths, List<String> list) {
        paths += root.data;

        if (root.left == null && root.right == null) {
            list.add(paths);
            return;
        }

        if (root.left != null) {
            helper(root.left,paths+"->",list);
        }

        if (root.right != null) {
            helper(root.right,paths+"->",list);
        }
    }

    static List<List<Integer>> allPaths (NodeTree node) {
        if (node == null) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs (node, path,result);

        return result;
    }

    static void dfs (NodeTree node, List<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null) {
            path.add(node.data);
            result.add(path);
        }

        path.add(node.data);

        if (node.left != null) {
            dfs (node.left,path,result);
        }

        if(node.right !=null) {
            dfs (node.right,path,result);
        }
    }
}
