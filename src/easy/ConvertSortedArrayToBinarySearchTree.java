package easy;

// 108. Convert Sorted Array to Binary Search Tree
public class ConvertSortedArrayToBinarySearchTree {
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

    private TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    private TreeNode generateTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (r + l) / 2;
        TreeNode newRoot = new TreeNode(nums[mid]);
        newRoot.left = generateTree(nums, l, mid - 1);
        newRoot.right = generateTree(nums, mid + 1, r);

        return newRoot;
    }
}
