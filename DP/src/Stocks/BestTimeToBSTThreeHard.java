package Stocks;

import java.util.Arrays;

public class BestTimeToBSTThreeHard {

  //Space Optimization
  public int maxProfitSO(int[] prices) {
    int[][] next = new int[2][3];
    int[][] curr = new int[2][3];

    for (int i = prices.length - 1; i >= 0 ; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        for (int k = 1; k <= 2; k++) {
          if (buy == 0) {
            int bought = next[1][k] - prices[i];
            int notBought = next[0][k];
            curr[buy][k] = Math.max(bought, notBought);
          } else {
            int sold = next[0][k - 1] + prices[i];
            int notSold = next[1][k];
            curr[buy][k] = Math.max(sold, notSold);
          }
        }
      }

      System.arraycopy(curr , 0 , next , 0 , curr.length);
    }
    return next[0][2];
  }

  //TABULATION
  public int maxProfitTab(int[] prices) {
    int[][][] dp = new int[prices.length + 1][2][3];

    for (int i = prices.length - 1; i >= 0 ; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        for (int k = 1; k <= 2; k++) {
          if (buy == 0) {
            int bought = dp[i + 1][1][k] - prices[i];
            int notBought = dp[i + 1][0][k];
            dp[i][buy][k] = Math.max(bought, notBought);
          } else {
            int sold = dp[i + 1][0][k - 1] + prices[i];
            int notSold = dp[i + 1][1][k];
            dp[i][buy][k] = Math.max(sold, notSold);
          }
        }
      }
    }
    return dp[0][0][2];
  }


  //RECURSION + MEMOIZATION
    int[][][] dp;
    public int solve(int i , int[] prices , int buy , int k){

      if(i == prices.length) return 0;
      if(k == 0) return 0;

      if(dp[i][buy][k] != -1){
        return dp[i][buy][k];
      }

      if(buy == 0){
        int bought = solve(i+1 , prices , 1 , k) - prices[i];
        int notBought = solve(i+1 , prices , 0 , k);
        dp[i][buy][k] = Math.max(bought , notBought);
      }

      else{
        int sold = solve(i+1 , prices , 0 , k-1) + prices[i];
        int notSold = solve(i+1 , prices , 1 , k);
        dp[i][buy][k] = Math.max(sold , notSold);
      }

      return dp[i][buy][k];
    }
    public int maxProfit(int[] prices) {
      dp = new int[prices.length + 1][2][5];
      for(int[][] matrix : dp){
        for(int[] row : matrix){
          Arrays.fill(row , -1);
        }
      }
      return solve(0 , prices , 0 , 2);
    }
  }

