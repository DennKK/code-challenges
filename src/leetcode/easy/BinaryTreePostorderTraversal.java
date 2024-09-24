package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 145. Binary Tree Postorder Traversal
public class BinaryTreePostorderTraversal {
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

    // The simplest solution
    private List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            if (curNode.right == null) {
                res.add(curNode.val);
                curNode = null;
            } else {
                TreeNode temp = curNode.right;
                curNode.right = null;
                stack.push(curNode);
                curNode = temp;
            }
        }

        return res;
    }

    // Second solution
    private List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        stack.push(root);
        visit.push(false);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean v = visit.pop();
            if (curr != null) {
                if (v) {
                    res.add(curr.val);
                } else {
                    stack.push(curr);
                    visit.push(true);

                    stack.push(curr.right);
                    visit.push(false);

                    stack.push(curr.left);
                    visit.push(false);
                }
            }
        }
        return res;
    }

    // Recursion solution
    private final List<Integer> res = new ArrayList<>();

    private List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
    }

    private void postorder(TreeNode node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        res.add(node.val);
    }
}
