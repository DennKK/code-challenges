package leetcode.easy;

import java.util.Stack;

// 226. Invert Binary Tree
public class InvertBinaryTree {
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

    private TreeNode invertTreeRecursively(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeRecursively(root.left);
        invertTreeRecursively(root.right);

        return root;
    }

    private TreeNode invertTreeIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur != null) {
                TreeNode temp = cur.right;
                cur.right = cur.left;
                cur.left = temp;
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }

        return root;
    }
}
