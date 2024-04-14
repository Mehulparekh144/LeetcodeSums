package Stocks;

import java.util.Arrays;

public class BestTimeToBSTFeeMedium {



  //RECURSION + MEMOIZATION
  int[][] dp;
  private int solve(int i , int[] prices , int buy , int fee){
    if(i == prices.length) return 0;
    if(dp[i][buy] != -1) return dp[i][buy];
    if(buy == 0){
      int bought = solve(i+1 , prices , 1 , fee) - prices[i];
      int notBought = solve(i+1 , prices , 0 , fee);
      return dp[i][buy] = Math.max(bought , notBought);
    }
    else{
      int sold = solve(i+1 , prices , 0 , fee) + prices[i] - fee;
      int notSold = solve(i+1 , prices , 1 , fee);
      return dp[i][buy] = Math.max(sold , notSold);
    }
  }
  public int maxProfit(int[] prices, int fee) {
    dp = new int[prices.length + 1][2];
    for(int[] row : dp){
      Arrays.fill(row , -1 );
    }
    return solve(0 , prices , 0 , fee);
  }
}
