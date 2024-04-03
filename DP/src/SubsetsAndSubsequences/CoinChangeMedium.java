package SubsetsAndSubsequences;

import java.util.Arrays;

public class CoinChangeMedium {

  // SPACE OPTIMIZATION
  public int coinChangeSO(int[] coins, int amount) {
    int n = coins.length;
    int[] prev = new int[amount + 1];

    for(int i = 0 ; i <= amount ; i++){
      if(i%coins[0] == 0){
        prev[i] = i/coins[0];
      } else{
        prev[i] = (int) Math.pow(10,9);
      }
    }

    for(int i = 1 ; i < n ; i++){
      int[] curr = new int[amount + 1];
      for(int t = 0 ; t <= amount ; t++){
        int np = prev[t];
        int p = (int) Math.pow(10,9);
        if(t >= coins[i]){
          p = 1 + curr[t-coins[i]];
        }

        curr[t] = Math.min(p , np);
      }
      prev = curr;
    }

    return prev[amount] >= (int)Math.pow(10,9) ? -1 : prev[amount];
  }

  int[][] dp;

  public int coinChangeTabulation(int[] coins, int amount) {
    int n = coins.length;
    dp = new int[n][amount + 1];
    for(int i = 0 ; i <= amount ; i++){
      if(i%coins[0] == 0){
        dp[0][i] = i/coins[0];
      } else{
        dp[0][i] = (int) Math.pow(10,9);
      }
    }

    for(int i = 1 ; i < n ; i++){
      for(int t = 0 ; t <= amount ; t++){
        int np = dp[i-1][t];
        int p = (int) Math.pow(10,9);
        if(t >= coins[i]){
          p = 1 + dp[i][t-coins[i]];
        }

        dp[i][t] = Math.min(p , np);
      }
    }

    return dp[n-1][amount] >= (int)Math.pow(10,9) ? -1 : dp[n-1][amount];
  }

  private int solve(int i , int[] coins , int amount){
    if(i == 0){
      if(amount%coins[i] == 0){
        return amount/coins[i];
      }
      return (int)Math.pow(10,9);
    }

    if(dp[i][amount] != -1) return dp[i][amount];

    int np = solve(i-1 , coins , amount);
    int p = Integer.MAX_VALUE;
    if(amount >= coins[i]){
      p = 1 + solve(i , coins , amount - coins[i]);
    }

    return dp[i][amount] = Math.min(p,np);
  }

  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    dp = new int[n][amount + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    int ans =  solve(n-1 , coins , amount);
    if(ans >= (int) Math.pow(10,9)) return -1;
    return ans;
  }
}
