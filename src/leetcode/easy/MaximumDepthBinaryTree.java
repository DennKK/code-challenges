package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// 104. Maximum Depth of Binary Tree
public class MaximumDepthBinaryTree {
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

    // Iterative DFS solution
    private int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 1;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int n = depth.pop();

            if (node != null) {
                res = Math.max(res, n);
                stack.push(node.left);
                stack.push(node.right);
                depth.push(n + 1);
                depth.push(n + 1);
            }
        }

        return res;
    }

    // Iterative BFS solution
    private int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
        }
        return level;
    }

    // Recursive DFS solution
    private int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth3(root.left);
        int right = maxDepth3(root.right);

        return Math.max(left, right) + 1;
    }
}
