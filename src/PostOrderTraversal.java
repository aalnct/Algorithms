import java.util.Stack;

class PostOrderNode {
    int value;
    PostOrderNode left;
    PostOrderNode right;

    PostOrderNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
public class PostOrderTraversal {

    public static void main(String[] args) {

    }

    // BFS apporach using stack ...
    static void traversal(PostOrderNode head) {
        if (head == null) {
            return;
        }

        Stack<PostOrderNode> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        stack.push(head);

        while (!stack.isEmpty()) {
            PostOrderNode current = stack.pop();
            result.push(current.value);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        while (!result.isEmpty()) {
            System.out.println(result.pop() + " ");
        }
    }

    // using recurssion

    static void postOrderTraversal(PostOrderNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value + " ");
    }
}
