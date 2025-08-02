import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {


     Set<List<Integer>> combos = new HashSet<>();

    public void dfs(int i, int[] nums, List<Integer> possibleCombo, int sum){
        if(sum == 0){
            combos.add(new ArrayList<>(possibleCombo));
            return;
        }

        if(sum<0 || i == nums.length){
            return;
        }


        // List<Integer> updatedCombo = new ArrayList<>(possibleCombo);
        possibleCombo.add(nums[i]);
        dfs(i, nums, possibleCombo, sum - nums[i]);
        possibleCombo.remove(possibleCombo.size()-1);

        dfs(i+1, nums, possibleCombo, sum);
        
        
    }
   
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0,candidates, new ArrayList<>(), target);
        List<List<Integer>> ans = new ArrayList<>(combos);

        // System.out.println(ans);

        return ans;
        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(ans);
    }

}