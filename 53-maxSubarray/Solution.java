class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int mx = nums[0];
        int curr = mx;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (curr + num >= num) {
                curr += num;
            } else {
                curr = num;
            }

            mx = Math.max(mx, curr);

        }

        return mx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int ans = sol.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(ans);

    }
}