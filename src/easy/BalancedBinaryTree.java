package easy;

// 110. Balanced Binary Tree
public class BalancedBinaryTree {
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

    private boolean balanced = true;

    private boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.abs(left - right) > 1) {
            balanced = false;
        }

        return 1 + Math.max(left, right);
    }
}
