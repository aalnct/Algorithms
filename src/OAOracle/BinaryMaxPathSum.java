package OAOracle;

class BinarySum {
    int data;
    BinarySum left;
    BinarySum right;

    public BinarySum (int data) {
        this.data = data;
        left = right = null;
    }
}
public class BinaryMaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinarySum node = new BinarySum(1);
        node.left = new BinarySum(2);
        node.right = new BinarySum(3);
        node.left.left = new BinarySum(4);
        node.left.right = new BinarySum(5);

        node.right.left = new BinarySum(6);
        node.right.right = new BinarySum(7);

        // System.out.println(maxPathSum(node));

        System.out.println(_maxPathSum(node));
    }
    // in the below solution I am not considering the combination of both
    // left and right subtree, and only considering it individually ...
    static int maxPathSum (BinarySum node) {
        if (node == null) {
            return 0;
        }

        int sum;
        int lSum = 1;
        int rSum = 1;

        lSum +=maxPathSum(node.left);
        rSum +=maxPathSum(node.right);

        sum = Math.max(lSum,rSum);

        return sum;
    }

    static int _maxPathSum(BinarySum node) {

        if (node == null) {
            return 0;
        }

        // calculate for each side
        int leftSum = Math.max(_maxPathSum(node.left),0);
        int rightSum = Math.max(_maxPathSum(node.right),0);

        // calculate the maximum path sum that includes the current node ...
        int current = node.data + leftSum + rightSum;

        // update global max sum if current is greater
        maxSum = Math.max(maxSum,current);

        //return the maximum path sum that can be extended to parent node ...
        return node.data + Math.max(leftSum,rightSum);
    }
}
