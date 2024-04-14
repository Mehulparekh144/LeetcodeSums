package Stocks;

public class BestTimeToBSTCooldownMedium {

  //SPACE OPTIMIZATION
  public int maxProfitSO(int[] prices) {
    int[] next = new int[2];
    int[] next2 = new int[2];
    int[] curr = new int[2];

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 0) {
          int bought = next[1] - prices[i];
          int notBought = next[0];
          curr[buy] = Math.max(bought, notBought);
        } else {
          int sold = prices[i] + next2[0];
          int notSold = next[1];
          curr[buy] = Math.max(sold, notSold);
        }
      }
      System.arraycopy(next , 0 , next2 , 0 , next.length);
      System.arraycopy(curr , 0 , next , 0 , curr.length);
    }
    return curr[0];
  }
  //TABULATION
  public int maxProfitTab(int[] prices) {
    int[][] dp = new int[prices.length + 2][2];

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 0) {
          int bought = dp[i + 1][1] - prices[i];
          int notBought = dp[i + 1][0];
          dp[i][buy] = Math.max(bought, notBought);
        } else {
          int sold = prices[i] + dp[i+2][0];
          int notSold = dp[i+1][1];
          dp[i][buy] = Math.max(sold, notSold);
        }
      }
    }
    return dp[0][0];
  }

  //MEMOIZATION + RECURSION
  int[][] dp;
  public int solve(int i , int[] prices , int buy){
    if(i >= prices.length) return 0;
    if(dp[i][buy] != -1) return dp[i][buy];
    if(buy == 0){
      int bought = solve(i+1 , prices , 1) - prices[i];
      int notBought = solve(i+1 , prices , 0);
      return dp[i][buy] = Math.max(bought , notBought);
    }
    else{
      int sold = prices[i] + solve(i+2 , prices , 0);
      int notSold = solve(i+1 , prices , 1);
      return dp[i][buy] = Math.max(sold , notSold);
    }
  }

  public int maxProfit(int[] prices) {
    dp = new int[prices.length + 1][2];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(0 , prices , 0);
  }
}
