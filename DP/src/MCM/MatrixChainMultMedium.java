package MCM;

import java.util.Arrays;

public class MatrixChainMultMedium {

  //TABULATION
  public static int mcmTab(int[] p){
    int n = p.length;

    int[][] dp = new int[n][n];

    for(int i = 1 ; i < p.length ; i++){
      dp[i][i] = 0;
    }
    for(int i = p.length - 1 ; i >= 1 ; i--){
      for(int j = i+1 ; j < n ; j++){
        int minSteps = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
          int steps = p[i-1]*p[k]*p[j] + dp[i][k] + dp[k+1][j];
          if(steps < minSteps) minSteps = steps;
        }
        dp[i][j] = minSteps;
      }
    }

    return dp[1][n-1];
  }


  //RECURSION + MEMOIZATION
  private static int solve(int i , int j , int[] p , int[][] dp ){
    if(i == j) return 0; // Only 1 matrix is remaining that means no operations can be done
    if(dp[i][j] != -1) return dp[i][j];
    int minSteps = Integer.MAX_VALUE;
    for(int k = i ; k < j ; k++){
      int steps = p[i - 1]*p[k]*p[j] + solve(i , k , p , dp) + solve(k+1 , j , p , dp);
      minSteps = Math.min(minSteps , steps);
    }
    return dp[i][j] = minSteps;
  }
  public static int mcm(int[] p){

    int n = p.length;
    int i = 1;
    int j = n-1;
    int[][] dp = new int[n][n];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(i , j , p , dp);

  }
}
