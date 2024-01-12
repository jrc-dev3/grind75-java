import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    private Set<List<Integer>> collectedSoFar = new HashSet<>();

    private List<int[]> twoSum(int target, int[] nums){
        
        Map<Integer, Integer> indexMap = new HashMap<>();

        List<int[]> indexPairs = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {

            int newTarget = target - nums[i];
            if(indexMap.containsKey(newTarget)){
                indexPairs.add(new int[]{nums[i], nums[indexMap.get(newTarget)]});
            }

            indexMap.put(nums[i], i );
            
        }

        return indexPairs;

            
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= nums.length - 3; i++) {

            int n = nums[i];
        
            int[] newNums = Arrays.copyOfRange(nums, i+1, nums.length);
            List<int[]> pairs = twoSum(0-n, newNums);

            for(int[] pair: pairs){

                List<Integer> entry = new ArrayList<>(){{
                    add(n);
                    add(pair[0]);
                    add(pair[1]);

                }};

                Collections.sort(entry);

                if(!collectedSoFar.contains(entry)){
                    collectedSoFar.add(entry);
                    ans.add(entry);
                }

                
            }

         
        }

        return ans;
       
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> ans = sol.threeSum(new int[]{-1,0,1,2,-1,-4});
        //List<List<Integer>> ans = sol.threeSum(new int[]{0,1,1});
        //List<List<Integer>> ans = sol.threeSum(new int[]{0,0,0});
        System.out.println(ans.size());
        for(List<Integer> li: ans){
            System.out.println(li);
        }
    }
}