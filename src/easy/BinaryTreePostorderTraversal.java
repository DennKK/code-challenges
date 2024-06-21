package easy;

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

    // Second solution
    private List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.right == null) {
                res.add(curr.val);
                if (!stack.isEmpty()) {
                    curr = stack.pop();
                    if (curr.left != null) {
                        curr.left = null;
                    } else {
                        curr.right = null;
                    }
                } else {
                    curr = null;
                }

            } else {
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res;
    }

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
