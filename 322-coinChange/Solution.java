import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {

            for(int coin: coins){
                int target = i - coin;

                if(target >= 0 && dp[target] != Integer.MAX_VALUE ){
                    dp[i] = Math.min(dp[i], 1 + dp[target]);
                }
            }           
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount]: -1;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.coinChange(new int[] {2}, 3);
        System.out.println(ans);
    }
}