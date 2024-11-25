package OAOracle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ListNodeRight {
    int value;
    ListNodeRight left;
    ListNodeRight right;

    public ListNodeRight (int value) {
        this.value = value;
    }
}

public class PrintRightBinaryTree {

    public static void main(String[] args) {
        ListNodeRight root = new ListNodeRight(1);
        root.left = new ListNodeRight(2);
        root.right = new ListNodeRight(3);
        root.left.right = new ListNodeRight(4);
        root.right.right = new ListNodeRight(5);

        List<Integer> result = printRightView(root);

        result.forEach(System.out::println);
    }

    static List<Integer> printRightView (ListNodeRight root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<ListNodeRight> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ListNodeRight lastNode = null;

            for (int i=0; i < levelSize; i++) {
                ListNodeRight current = queue.poll();
                if (current != null) {
                    lastNode = current;
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            if (lastNode != null) {
                result.add(lastNode.value);
            }
        }
        return result;
    }
}
