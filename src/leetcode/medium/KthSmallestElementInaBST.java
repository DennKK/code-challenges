package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 230. Kth Smallest Element in a BST
public class KthSmallestElementInaBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Iterative solution
    private int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }

    // Recursive solution
    private final List<Integer> res = new ArrayList<>();

    private int kthSmallest2(TreeNode root, int k) {
        inorder(root);
        return res.get(k - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        res.add(node.val);
        inorder(node.right);
    }
}
