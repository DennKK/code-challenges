package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 144. Binary Tree Preorder Traversal
public class BinaryTreePreorderTraversal {
    static class TreeNode {
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
    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }

        return res;
    }

    // Recursive solution
    private final List<Integer> res = new ArrayList<>();

    private List<Integer> recursivePreorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}
