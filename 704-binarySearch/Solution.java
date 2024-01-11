import java.util.Arrays;

class Solution {

    private int _search(int[] nums, int target, int startIndex){
      if(nums.length == 0) return -1;
      // if(nums.length == 1 && nums[0] != target) return -1

      int s = 0;
      int e = nums.length;

      int mid = Math.floorDiv(s+e, 2);
      int midVal = nums[mid];

      if(midVal == target){
        return startIndex + mid;
      }else if(midVal < target){
        int[] newNums = Arrays.copyOfRange(nums, mid + 1, e);
        return _search(newNums, target, startIndex + mid + 1);
      }else{
        int[] newNums = Arrays.copyOfRange(nums, s, mid);
        return _search(newNums, target, startIndex);
      }
    
    }

    public int search(int[] nums, int target) {
      return _search(nums, target, 0);
    }

    public static void main(String[] args) {
      Solution sol = new Solution();
      int ans = sol.search(new int[]{-1,0,3,5,9,12}, 9);
      System.out.println(ans);
    }
}