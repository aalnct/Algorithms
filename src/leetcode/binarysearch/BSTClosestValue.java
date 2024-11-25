package leetcode.binarysearch;

import java.util.Map;

class NodeLCA {
    int value;
    NodeLCA left;
    NodeLCA right;

    public NodeLCA (int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BSTClosestValue {

    public static void main(String[] args) {
        NodeLCA node = new NodeLCA(4);
        node.left = new NodeLCA(2);
        node.right = new NodeLCA(5);
        node.left.left = new NodeLCA(1);
        node.left.right = new NodeLCA(3);

        double target = 3.7;

        System.out.println(closesValue(node,target));
    }

    private static int closesValue(NodeLCA root, double target) {
        int closest = root.value;
        while (root != null) {
            if (Math.abs(target - root.value) < Math.abs(target - closest)) {
                closest = root.value;
            }

            root = (target < root.value) ? root.left : root.right;
        }
        return closest;
    }
}
