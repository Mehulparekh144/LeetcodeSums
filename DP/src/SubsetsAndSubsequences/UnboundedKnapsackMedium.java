package SubsetsAndSubsequences;

import java.util.Arrays;

public class UnboundedKnapsackMedium {

  //SPACE OPTIMIZATION
  public static int unboundedKnapsackSO(int n, int w, int[] profit, int[] weight) {
    // Write your code here.
    int[] prev = new int[w+1];

    for(int wt = 0 ; wt <= w ; wt++){
      prev[wt] = (wt/weight[0])*profit[0];
    }

    for(int i = 1 ; i < n ; i++){
      int[] curr = new int[w+1];
      for(int k = 0 ; k <= w ; k++){
        int np =prev[k];
        int p = (int) Math.pow(-10 , 9);
        if(weight[i] <= k){
          p = profit[i] + curr[k-weight[i]];
        }

        curr[k] = Math.max(p , np);
      }

      prev = curr;

    }

    return prev[w];
  }

  // TABULATION
  public static int unboundedKnapsackTab(int n, int w, int[] profit, int[] weight) {
    // Write your code here.
    int[][] dp = new int[n][w+1];

    for(int wt = 0 ; wt <= w ; wt++){
      dp[0][wt] = (wt/weight[0])*profit[0];
    }

    for(int i = 1 ; i < n ; i++){
      for(int k = 0 ; k <= w ; k++){
        int np = dp[i-1][k];
        int p = (int) Math.pow(-10 , 9);
        if(weight[i] <= k){
          p = profit[i] + dp[i][k-weight[i]];
        }

        dp[i][k] = Math.max(p , np);
      }
    }

    return dp[n-1][w];
  }

  // MEMOIZATION + RECURSION
  public static int solve(int i , int w , int[] profit , int[] weight , int[][] dp){
    if( i == 0){
      return w/weight[i] * profit[i];
    }

    if(dp[i][w] != -1) return dp[i][w];

    int np = solve(i-1 , w , profit , weight , dp);
    int p =(int) Math.pow(-10 , 9);
    if(w >= weight[i]){
      p = profit[i] + solve(i , w-weight[i] , profit , weight , dp);
    }

    return dp[i][w] = Math.max(p , np);
  }
  public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    // Write your code here.
    int[][] dp = new int[n][w+1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(n-1 , w , profit , weight , dp);
  }
}
