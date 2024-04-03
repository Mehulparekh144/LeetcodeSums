package SubsetsAndSubsequences;

import java.util.Arrays;

public class Knapsack01Easy {

  static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {

    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Change in the given tree itself.
     * No need to return or print the output.
     * Taking input and printing output is handled automatically.
     */
    int[][] dp = new int[n][maxWeight + 1];
    for(int i = weight[0] ; i <= maxWeight ; i++){
      dp[0][i] = value[0];
    }

    for(int i = 1 ; i < n ; i++){
      for(int wt = 0 ; wt <= maxWeight ; wt++){
        int np = dp[i-1][wt];
        int p = Integer.MIN_VALUE;
        if(wt >= weight[i]){
          p = value[i] + dp[i-1][wt - weight[i]];
        }
        dp[i][wt] = Math.max(p , np);
      }
    }

    return dp[n-1][maxWeight];
  }

  private static int solve(int i , int[] weight , int[] value , int maxWeight , int[][] dp){
    if(i == 0){
      if(weight[i] <= maxWeight){
        return value[i];
      }
      return 0;
    }

    if(dp[i][maxWeight] != -1){
      return dp[i][maxWeight];
    }

    int np = solve(i-1 , weight , value , maxWeight, dp);
    int p = Integer.MIN_VALUE;
    if(maxWeight >= weight[i]){
      p = value[i] + solve(i-1 , weight , value , maxWeight - weight[i],dp);
    }
    return dp[i][maxWeight] = Math.max(p , np);
  }

  static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Change in the given tree itself.
     * No need to return or print the output.
     * Taking input and printing output is handled automatically.
     */
    int[][] dp = new int[n][maxWeight + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(n-1 , weight , value , maxWeight , dp);
  }
}
