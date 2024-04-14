package Stocks;

import java.util.Arrays;

public class BestTimeToBSTwoMedium {

  //SPACE OPTIMIZATION
  public int maxProfitSO(int[] prices, int fee) {
    int[] prev = new int[2];
    int[] curr = new int[2];

    for(int i = prices.length - 1 ; i >= 0 ; i-- ){
      for(int buy = 0 ; buy <= 1 ; buy++){
        if(buy == 0){
          int bought = prev[1] - prices[i];
          int notBought = prev[0];
          curr[buy] = Math.max(bought , notBought);
        }
        else{
          int sold = prev[0] + prices[i] - fee;
          int notSold = prev[1];
          curr[buy] = Math.max(sold , notSold);
        }
      }

      System.arraycopy(curr , 0 , prev , 0 , curr.length);
    }

    return curr[0];
  }

  //TABULATION
  public int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length + 1][2];

    for(int i = prices.length - 1 ; i >= 0 ; i-- ){
      for(int buy = 0 ; buy <= 1 ; buy++){
        if(buy == 0){
          int bought = dp[i+1][1] - prices[i];
          int notBought = dp[i+1][0];
          dp[i][buy] = Math.max(bought , notBought);
        }
        else{
          int sold = dp[i+1][0] + prices[i] - fee;
          int notSold = dp[i+1][1];
          dp[i][buy] = Math.max(sold , notSold);
        }
      }
    }

    return dp[0][0];
  }

  //SPACE OPTIMIZATION;
  public int maxProfitSO(int[] prices) {
    int[] next = new int[2];
    int[] curr = new int[2];
    int profit;

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 1) {
          int bought = next[0] - prices[i];
          int notBought = next[1];
          profit = Math.max(bought, notBought);
        } else {
          int sold = prices[i] + next[1];
          int notSold = next[0];
          profit = Math.max(sold, notSold);
        }
        curr[buy] = profit;
      }

      System.arraycopy(curr , 0 , next , 0 , curr.length);
    }

    return next[1];
  }
  //TABULATION
  public int maxProfitTab(int[] prices) {
    int[][] dp = new int[prices.length + 1][2];
    dp[prices.length][0] = 0;
    dp[prices.length][1] = 0;
    int profit;

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 1) {
          int bought = dp[i + 1][0] - prices[i];
          int notBought = dp[i + 1][1];
          profit = Math.max(bought, notBought);
        } else {
          int sold = prices[i] + dp[i + 1][1];
          int notSold = dp[i + 1][0];
          profit = Math.max(sold, notSold);
        }
        dp[i][buy] = profit;
      }
    }

    return dp[0][1];}


  //RECURSION + MEMOIZATION
  int[][] dp;
  private int solve(int i , int buy , int[] prices){
    if(i == prices.length) return 0;

    if(dp[i][buy] != -1){
      return dp[i][buy];
    }

    if(buy == 1) // That means user has ability to buy
    {
      // Bought so I have to sell now and whatever ans i get from selling i ll minus it by prices[i]
      int bought = solve(i+1 , 0 , prices) - prices[i];
      // I won't buy this share
      int notBought = solve(i+1 , 1 , prices);
      dp[i][buy] = Math.max(bought , notBought);
    }

    else{
      // This means I have solve it and now I have to buy stocks. If I sold I ll get the current price.
      int sold = prices[i] + solve(i+1 , 1 , prices);
      int notSold = solve(i+1 , 0 , prices);
      dp[i][buy] = Math.max(sold , notSold);
    }

    return dp[i][buy];
  }
  public int maxProfitMEMO(int[] prices) {
    dp = new int[prices.length][2];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(0 , 1 , prices);
  }

  //GREEDY
  public int maxProfit(int[] prices) {
    int profit = 0 ;
    for(int i = 1 ; i < prices.length; i++){
      if(prices[i] >= prices[i-1]){
        profit += prices[i] - prices[i-1];
      } else{
        profit += 0;
      }
    }

    return profit;
  }
}
