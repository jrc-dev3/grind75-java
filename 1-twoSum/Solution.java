import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

  public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {

            int newTarget = target - nums[i];

            if(indexMap.containsKey(newTarget)){
                return new int[]{i, indexMap.get(newTarget)};
            }

            indexMap.put(nums[i], i );
            
        }

        return new int[]{};

  }

  public static void main(String[] args) {

    int[] nums = new int[] { 3, 2, 4 };
    int target = 6;

    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));

  }

}
