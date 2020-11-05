package ds.leetcode.BinarySearchTree;

/**
 * Created by AmitAgarwal on 5/28/20.
 */
public class BinaryFindDepth {

    public static void main(String[] args) {

    }

    public static int maxDepth(Node root){
        int maxDepth = 0;
        if(root == null){
            return maxDepth;
        }
        return getDepth(root,1);
    }

    private static int getDepth(Node root, int depth) {
        if(root.rightChild == null && root.leftChild == null){
            return depth;
        }

        int maxLength = 0;
        if(root.leftChild != null){
            maxLength = getDepth(root.leftChild,depth+1);
        }else if(root.rightChild!=null){
            int len = getDepth(root.rightChild,depth+1);
            if(len > maxLength){
                maxLength = len;
            }
        }
        return maxLength;
    }
}
