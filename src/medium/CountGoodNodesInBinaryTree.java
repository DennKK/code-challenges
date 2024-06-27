package medium;

// 1448. Count Good Nodes in Binary Tree
public class CountGoodNodesInBinaryTree {
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

    private int goodNodes1(TreeNode root) {
        return dfs1(root, root.val);
    }

    private int dfs1(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int res = node.val >= maxVal ? 1 : 0;
        maxVal = Math.max(node.val, maxVal);
        res += dfs1(node.left, maxVal);
        res += dfs1(node.right, maxVal);

        return res;
    }


    // Variation 2
    private int counter = 0;

    private int goodNodes2(TreeNode root) {
        dfs2(root, Integer.MIN_VALUE);
        return counter;
    }

    private void dfs2(TreeNode node, int curMaxVal) {
        if (node == null) {
            return;
        }

        if (node.val < curMaxVal) {
            dfs2(node.left, curMaxVal);
            dfs2(node.right, curMaxVal);
        } else {
            counter++;
            dfs2(node.left, node.val);
            dfs2(node.right, node.val);
        }
    }
}
