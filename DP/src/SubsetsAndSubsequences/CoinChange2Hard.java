package SubsetsAndSubsequences;

import java.util.Arrays;

public class CoinChange2Hard {

  //SPACE OPTIMIZATION
  public int changeOpt(int amount, int[] coins) {
    int n = coins.length;
    int[] prev = new int[amount + 1];

    for(int a = 0 ; a <= amount ; a++){
      if(a%coins[0] == 0){
        prev[a] = 1;
      }
    }

    for(int i = 1 ; i < n ; i++){
      int[] curr = new int[amount + 1];
      for(int k = 0 ; k <= amount ; k++){
        int np = prev[k];
        int p = 0;
        if(k >= coins[i]){
          p = curr[k-coins[i]];
        }

        curr[k] = np + p;
      }

      prev = curr;
    }
    return prev[amount];
  }
  int[][] dp;
  // TABULATION
  public int changeTabulation(int amount, int[] coins) {
    int n = coins.length;
    dp = new int[n][amount + 1];

    for(int a = 0 ; a <= amount ; a++){
      if(a%coins[0] == 0){
        dp[0][a] = 1;
      }
    }

    for(int i = 1 ; i < n ; i++){
      for(int k = 0 ; k <= amount ; k++){
        int np = dp[i-1][k];
        int p = 0;
        if(k >= coins[i]){
          p = dp[i][k-coins[i]];
        }

        dp[i][k] = np + p;
      }
    }
    return dp[n-1][amount];
  }

  //RECURSION + MEMOIZATION
//  int[][] dp;
  public int solve(int i , int amount , int[] coins){
    if(i == 0){
      if(amount%coins[0] == 0){
        return 1;
      }
      return 0;
    }

    if(dp[i][amount] != -1) return dp[i][amount];
    int np = solve(i-1 , amount , coins);
    int p = 0;
    if(amount >= coins[i]){
      p = solve(i , amount - coins[i] , coins);
    }
    dp[i][amount] = np + p;
    return dp[i][amount];
  }
  public int change(int amount, int[] coins) {
    int n = coins.length;
    dp = new int[n][amount + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(n-1 , amount , coins);
  }

  public static void main(String[] args) {
    CoinChange2Hard a = new CoinChange2Hard();
    System.out.println(a.change(5 , new int[]{1,2,5}));
  }
}
