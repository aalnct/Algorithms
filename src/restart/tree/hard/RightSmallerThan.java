package restart.tree.hard;

import java.util.Arrays;

class BinaryTreeNode {
    int val;
    int leftCount; // to maintain count of nodes in left subtree
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode (int val) {
        this.val = val;
        this.leftCount = 0;
        this.left = null;
        this.right = null;
    }
}


public class RightSmallerThan {

    // there are two-way to solve this
    // Brute force approach using nested for loop with
        // time complexity : O(n^2)

    // Using Binary Search Tree (Bit Modified)
     // time complexity : O(n log(n))
     // but if tree is skewed then time complexity becomes O(n^2)

    public static void main(String[] args) {
        int [] nums = {5,2,6,1};
        System.out.println(Arrays.toString(rightSmallerThanBruteForce(nums)));

        System.out.println(Arrays.toString(rightSmallerThanBinarySearchTree(nums)));
    }

    static int [] rightSmallerThanBruteForce(int [] arr) {
        int n = arr.length;
        int [] res = new int[n];

        if (arr.length == 0 || arr == null) {
            return res;
        }

        for (int i=0; i < n; i ++) {
            int count = 0;
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
            res [i] = count;
        }

        return res;
    }


    static int [] rightSmallerThanBinarySearchTree (int [] nums) {
        int n = nums.length;
        int [] res = new int[n];

        if (nums.length == 0 || nums == null) {
            return res;
        }

        BinaryTreeNode root = new BinaryTreeNode(nums[n-1]); // starting from
                                                            // right most node

        res[n-1] = 0; // no element is smaller than right most element to it right

        for (int i = n-2; i >=0; i--) {
            res[i] = insertAndCount(root, nums[i]);
        }

        return res;
    }

    static int insertAndCount (BinaryTreeNode root, int val) {
        int count = 0;
        BinaryTreeNode curr = root;

        while (true) {
            if (val <= curr.val) {
                curr.leftCount++;
                if (curr.left == null) {
                    curr.left = new BinaryTreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                // get the count
                count += curr.leftCount + (val > curr.val ? 1 : 0);
                if (curr.right == null) {
                    curr.right = new BinaryTreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return count;
    }
}
