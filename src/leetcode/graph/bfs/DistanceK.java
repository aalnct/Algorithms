package leetcode.graph.bfs;

import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
public class DistanceK {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        TreeNode target = new TreeNode(5);

        distanceK(node,node.left,2).forEach(System.out::println);
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Create a Parent Map
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();

        // create queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // marking visited nodes as visited
        Set<TreeNode> visited = new HashSet<>();

        // build the Parent Map
        buildParentMap(root, null, parentMap, queue); // sending it as null since for root, parent is null

        List<Integer> result = new ArrayList<>();

        bfs(target,k, visited,result,parentMap);

        return result;
    }

    private static void bfs(TreeNode target, int k, Set<TreeNode> visited, List<Integer> result, Map<TreeNode, TreeNode> parentMap) {
        // create a queue for bfs traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        // distance to keep track
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                for(int i=0; i < size; i++) {
                    result.add(queue.poll().value);
                }
                return;
            }

            // need to do level order traversing to know how many nodes at each level
            for(int i=0; i < size; i++) {
                // dequeue the current node
                TreeNode current = queue.poll();

                // if left child is not visited
                if (current.left != null && visited.add(current.left)) {
                    queue.offer(current.left);
                }
                if (current.right != null && visited.add(current.right)) {
                    queue.offer(current.right);
                }

                // Enqueue parent if not visited ...
                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            distance++;
        }
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode,TreeNode> parentMap, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        parentMap.put(node,parent);
        queue.offer(node);

        // right and left child
        buildParentMap(node.left, parent, parentMap, queue);
        buildParentMap(node.right,parent,parentMap,queue);
    }
}
