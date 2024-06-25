package easy;

// 572. Subtree of Another Tree
public class SubtreeOfAnotherTree {
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

    // First variation O(n * m)
    private boolean subtree = false;

    private boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        dfs(root, subRoot);
        return subtree;
    }

    private void dfs(TreeNode node, TreeNode subRoot) {
        if (node == null) {
            return;
        }

        if (node.val == subRoot.val) {
            if (isSame(node, subRoot)) {
                subtree = true;
                return;
            }
        }

        dfs(node.left, subRoot);
        dfs(node.right, subRoot);
    }

    private boolean isSame(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) {
            return false;
        }

        return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
    }
}
