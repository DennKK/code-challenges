package medium;

// 98. Validate Binary Search Tree
public class ValidateBinarySearchTree {
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

    private boolean isValidBST(TreeNode root) {
        return dfs(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean dfs(TreeNode node, double left, double right) {
        if (node == null) {
            return true;
        }

        boolean isValid = left < node.val && node.val < right;
        return isValid && dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }
}
