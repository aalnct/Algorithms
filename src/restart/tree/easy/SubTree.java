package restart.tree.easy;

class Tree_1 {

    int value;
    Tree_1 left;
    Tree_1 right;

    public Tree_1 (int value) {
        this.value = value;
    }
}

class SubTree_1 {
    int value;
    SubTree_1 left;
    SubTree_1 right;

    public SubTree_1 (int value) {
        this.value = value;
    }
}

public class SubTree {

    public static void main(String[] args) {
        Tree_1 tree = new Tree_1(1);
        tree.left = new Tree_1(2);
        tree.right = new Tree_1(3);

        SubTree_1 subTree = new SubTree_1(1);
        subTree.left = new SubTree_1(2);
        subTree.right = new SubTree_1(3);

        System.out.println(isSubTree(tree,subTree));
    }

    private static boolean isSubTree (Tree_1 root, SubTree_1 subTree) {
        if (subTree == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root,subTree)) {
            return true;
        }

        return isSubTree(root.left,subTree) || isSubTree(root.right,subTree);
    }

    private static boolean isSameTree (Tree_1 root, SubTree_1 subTree) {
        if (root == null && subTree == null) {
            return true;
        }
        if (root == null || subTree == null) {
            return false;
        }
        if (root.value != subTree.value) {
            return false;
        }

        return isSameTree(root.left,subTree.left)
                && isSameTree(root.right,subTree.right);
    }

}
