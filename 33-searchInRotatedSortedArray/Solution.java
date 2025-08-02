import java.util.Arrays;

class Solution {
    public int bs(int[] nums, int target){

        int lptr = 0;
        int rptr = nums.length - 1;

        while(lptr <= rptr){

            int mid = ((rptr-lptr)/2) + lptr;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                lptr = mid+1;
                continue;
            }

            rptr = mid-1;
        }

        return -1;

    }

    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        }

        int lptr = 0;
        int rptr = nums.length - 1;

        while (lptr != rptr) {
            int mid = ((rptr - lptr) / 2) + lptr;
            if (nums[mid] > nums[rptr]) {
                lptr++;
                continue;
            }

            if (nums[mid] < nums[rptr]) {
                rptr--;
                continue;
            }
        }

        int pivot = lptr;

        lptr = 0;
        rptr = nums.length - 1;

        if(nums[pivot] <= target && target <= nums[nums.length-1]){
            // System.out.println("In right side of pivot: " + Integer.toString(pivot) + ", " + Integer.toString(rptr));
            // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, pivot, rptr+1)));

            int ans = bs(Arrays.copyOfRange(nums, pivot, rptr+1), target);
            if(ans == -1){
                return ans;
            }
            return ans + pivot;
        }

        return bs(Arrays.copyOfRange(nums, 0, pivot), target);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.search(new int[] { 5,1,3}, 2);
        System.out.println(ans);


    }

}