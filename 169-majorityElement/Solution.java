import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int target = Math.floorDiv(nums.length, 2);

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if(!count.containsKey(curr))
                count.put(curr, 0);

            int newVal = count.get(curr) + 1;
            count.put(curr, newVal);

            if(newVal > target)
                return curr;
        }

        return -1;

        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.majorityElement(new int[]{3,2,2});
        System.out.println(ans);
    }
}