import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

class Solution {

  private static int indexOf(int[] arr, int target, int skipIndex) {
    int index = 0;
    boolean found = false;

    for (int obj : arr) {
      if (index == skipIndex) {
        index++;
        continue;
      }

      if (obj == target) {
        found = true;
        break;
      }

      index++;

    }
    return found == true ? index : -1;

  }


  public static int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> instanceCount = new HashMap<Integer, Integer>();
    for (int n : nums) {
      if (!instanceCount.containsKey(n)) {
        instanceCount.put(n, 0);
      }
      instanceCount.put(n, instanceCount.get(n) + 1);
    }

    int startIndex = 0;
    int matchingNumber = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      int weWant = target - n;

      if (instanceCount.containsKey(weWant)) {

        if (weWant == n) {

          if (instanceCount.get(n) > 1) {
            matchingNumber = weWant;
            startIndex = i;
            break;
          }
        } else {
          matchingNumber = weWant;
          startIndex = i;
          break;
        }

      }

    }

    return new int[] { startIndex, indexOf(nums, matchingNumber, startIndex) };

  }

  public static void main(String[] args) {

    int[] nums = new int[] { 3, 2, 4 };
    int target = 6;

    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));

  }

}
