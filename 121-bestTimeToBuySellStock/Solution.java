class Solution {
  public int maxProfit(int[] prices) {

    int maxSellInFuture = 0;
    int maxProfit = 0;

    for (int i = prices.length - 1; i >= 0; i--) {
      int currBuy = prices[i];

      if (maxSellInFuture - currBuy > 0) {
        maxProfit = Math.max(maxProfit, maxSellInFuture - currBuy);
      }

      maxSellInFuture = Math.max(maxSellInFuture, currBuy);

    }

    System.out.println(maxProfit);
    return maxProfit;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.maxProfit(new int[] { 7,6,4,3,1});

  }

}