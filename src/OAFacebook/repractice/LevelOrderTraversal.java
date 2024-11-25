package OAFacebook.repractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(3);
        tree.left = new BinaryTree1(9);
        tree.right = new BinaryTree1(20);
        tree.right.left = new BinaryTree1(15);
        tree.right.right = new BinaryTree1(7);

        List<List<Integer>> list = levelOrderTraversal(tree);
        list.stream().forEach(System.out::println);
    }

    static List<List<Integer>> levelOrderTraversal(BinaryTree1 tree) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<BinaryTree1> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i < size; i++) {
                BinaryTree1 current = queue.poll();
                list.add(current.data);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
