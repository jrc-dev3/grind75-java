import java.util.HashMap;
import java.util.Map;

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

    Map<TreeNode, Integer> memo = new HashMap<>();
    private int getMaxDepth(TreeNode root){
        if(memo.containsKey(root)) return memo.get(root);
        if(root == null) return 0;

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        int maxlr = Math.max(left, right);

        memo.put(root, 1 + maxlr);
        return 1 + maxlr;
    }

    int mx = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        mx = Math.max(mx, left + right);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return memo.get(root);

    }
}