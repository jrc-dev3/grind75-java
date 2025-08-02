import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private void dfs(int[] nums, List<Integer> curr, boolean[] used, Set<List<Integer>> perms) {
        if (curr.size() == nums.length) {
            perms.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            curr.add(nums[i]);
            used[i] = true;
            dfs(nums, curr, used, perms);

            curr.remove(curr.size() - 1);
            used[i] = false;

        }

    }

    public List<List<Integer>> permute(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used, result);

        return new ArrayList<>(result);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.permute(new int[] { 1, 2, 3 });
        System.out.println(ans);
    }

}