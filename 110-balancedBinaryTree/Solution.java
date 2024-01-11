
class Solution {

    private class TreeNode {
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

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.right == null && root.left == null)
            return true;

        int ldepth = getDepth(root.left);
        int rdepth = getDepth(root.right);

        int diff = Math.abs(rdepth - ldepth);

        if (diff > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

}