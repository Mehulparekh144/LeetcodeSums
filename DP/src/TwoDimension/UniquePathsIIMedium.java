package TwoDimension;

import java.util.Arrays;

public class UniquePathsIIMedium {
  int[][] dp;
  public int solve(int m , int n , int[][] grid){
    if(m < 0 || n < 0 || grid[m][n] == 1){
      return 0;
    }
    if(m == 0 && n == 0){
      return 1;
    }
    if(dp[m][n] != -1){
      return dp[m][n];
    }
    int up = solve(m-1 , n , grid);
    int left = solve(m , n-1 , grid);
    dp[m][n] = up + left;
    return dp[m][n];
  }
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    dp = new int[m][n];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(m-1 , n-1 , obstacleGrid);
  }
}
