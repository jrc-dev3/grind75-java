class Solution {

    public class TreeNode {
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

    private boolean bfs_greater(TreeNode root, int val) {
        if (root == null)
            return true;

        if (root.val <= val)
            return false;

        return bfs_greater(root.left, val) && bfs_greater(root.right, val);

    }

    private boolean bfs_less(TreeNode root, int val) {
        if (root == null)
            return true;

        if (root.val >= val)
            return false;

        return bfs_less(root.left, val) && bfs_less(root.right, val);

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        boolean levelAns = bfs_less(root.left, root.val) && bfs_greater(root.right, root.val);
        return levelAns && isValidBST(root.left) && isValidBST(root.right);

    }

}