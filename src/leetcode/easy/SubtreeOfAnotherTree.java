package leetcode.easy;

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

    // First variation. Time Complexity: O(n * m)
    private boolean subtree = false;

    private boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        dfs1(root, subRoot);
        return subtree;
    }

    private void dfs1(TreeNode node, TreeNode subRoot) {
        if (node == null) {
            return;
        }

        if (node.val == subRoot.val) {
            if (isSame1(node, subRoot)) {
                subtree = true;
                return;
            }
        }

        dfs1(node.left, subRoot);
        dfs1(node.right, subRoot);
    }

    private boolean isSame1(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) {
            return false;
        }

        return isSame1(tree1.left, tree2.left) && isSame1(tree1.right, tree2.right);
    }

    // Second variation. Time Complexity also: O(n * m)
    private boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSame2(root, subRoot)) {
            return true;
        }

        return isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);
    }

    private boolean isSame2(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) {
            return false;
        }

        return isSame2(tree1.left, tree2.left) && isSame2(tree1.right, tree2.right);
    }
}
