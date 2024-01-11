
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

  private void _invertTree(TreeNode root){
    if(root == null) return;

    TreeNode left = root.left;
    TreeNode right = root.right;

    _invertTree(left);
    _invertTree(right);

    root.right = left;
    root.left = right;

  } 

  public TreeNode invertTree(TreeNode root) {
    _invertTree(root);
    return root;
  }
}