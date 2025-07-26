import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> q = new ArrayDeque<>(){{ add(root); }};

        while(q.size() != 0){
            List<Integer> levelNodes = new ArrayList<>();
            int size = q.size();

            while(size-- > 0){
                TreeNode entry = q.pollFirst();
                levelNodes.add(entry.val);

                if(entry.left != null)
                    q.add(entry.left);
                
                if(entry.right != null)
                    q.add(entry.right);

            }

            ans.add(levelNodes);

        }
    
        return ans;
    }
}