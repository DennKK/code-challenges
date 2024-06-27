package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199. Binary Tree Right Side View
public class BinaryTreeRightSideView {
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

    // Variation 1
    private List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode rightSide = null;

            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    rightSide = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }

        return res;
    }

    // Variation 2
    private List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.poll();

                if (i == len - 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
