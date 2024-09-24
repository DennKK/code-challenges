package leetcode.easy;

// 543. Diameter of Binary Tree
public class DiameterOfBinaryTree {
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


    private int res = 0;

    private int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        res = Math.max(res, left + right + 2);

        return 1 + Math.max(left, right);
    }
}
