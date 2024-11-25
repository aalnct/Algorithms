package OAOracle;

class NodeLCA {
    int data;
    NodeLCA left;
    NodeLCA right;

    public NodeLCA (int data) {
        this.data = data;
        left = right = null;
    }
}
public class BinaryTreeLCA {

    public static void main(String[] args) {
        NodeLCA node = new NodeLCA(1);
        node.left = new NodeLCA(2);
        node.right = new NodeLCA(3);
        node.left.left = new NodeLCA(4);
        node.left.right = new NodeLCA(5);
        node.right.left = new NodeLCA(6);
        node.right.right = new NodeLCA(7);

        int n1 = 6;
        int n2 = 7;

        NodeLCA result = findLCA(node,n1,n2);
        System.out.println(result.data);
    }

    static NodeLCA findLCA (NodeLCA node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        NodeLCA leftLCA = findLCA(node.left,n1, n2);
        NodeLCA rightLCA = findLCA(node.right,n1,n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }
         return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
