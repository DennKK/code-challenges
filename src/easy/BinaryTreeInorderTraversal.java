package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94. Binary Tree Inorder Traversal
public class BinaryTreeInorderTraversal {
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

    // First iterative solution
    private List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    // Second iterative solution
    private List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();

            if (curNode.left == null) {
                result.add(curNode.val);
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().left = null;
                }
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
            } else {
                stack.push(curNode.left);
            }
        }

        return result;
    }

    // Recursive solution
    private List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
