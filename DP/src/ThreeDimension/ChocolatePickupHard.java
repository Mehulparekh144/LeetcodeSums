package ThreeDimension;

import java.util.Arrays;

public class ChocolatePickupHard {

  //TABULATION
  public static int maximumChocolates(int r, int c, int[][] grid) {
    int[][][] dp = new int[r][c][c];

    for (int j1 = 0; j1 < c; j1++) {
      for (int j2 = 0; j2 < c; j2++) {
        if (j1 == j2) {
          dp[r - 1][j1][j2] = grid[r - 1][j1];
        } else {
          dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
        }
      }
    }

    for (int i = r - 2;i >= 0; i--) {
      for (int j1 = 0; j1 < c; j1++) {
        for (int j2 = 0; j2 < c; j2++) {
          int maxi = Integer.MIN_VALUE;
          for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
              int value;
              if (j1 == j2) {
                value = grid[i][j1] ;
              } else {
                value = grid[i][j1] + grid[i][j2] ;
              }

              if((j1 + dj1 < 0 || j1 + dj1 >= c) || (j2 + dj2 < 0 || j2 + dj2 >= c)){
                value += (int) Math.pow(-10,9);
              } else{
                value += dp[i + 1][j1 + dj1][j2 + dj2];
              }
              maxi = Math.max(value, maxi);
            }
          }
          dp[i][j1][j2] = maxi;
        }
      }
    }

    return dp[0][0][c-1];
  }

  // MEMOIZATION
//  public static int solve(int i, int j1, int j2, int[][] grid , int[][][] dp) {
//    if (j1 < 0 || j1 > grid[0].length - 1 ||
//            j2 < 0 || j2 > grid[0].length - 1) {
//      return (int) (Math.pow(-10, 9));
//    }
//
//    if(dp[i][j1][j2] != -1){
//      return dp[i][j1][j2];
//    }
//
//    if (i == grid.length - 1) {
//      if (j1 == j2) {
//        return grid[i][j1];
//      }
//      return grid[i][j1] + grid[i][j2];
//    }
//    int maxi = Integer.MIN_VALUE;
//    for (int dj1 = -1; dj1 <= 1; dj1++) {
//      for (int dj2 = -1; dj2 <= 1; dj2++) {
//        int value;
//        if (j1 == j2) {
//          value = grid[i][j1] + solve(i + 1, j1 + dj1, j2 + dj2, grid , dp);
//        } else {
//          value = grid[i][j1] + grid[i][j2] + solve(i + 1, j1 + dj1, j2 + dj2, grid , dp);
//        }
//        maxi = Math.max(value, maxi);
//      }
//    }
//
//    return dp[i][j1][j2] = maxi;
//  }
//
//  public static int maximumChocolates(int r, int c, int[][] grid) {
//    // Write your code here.
//    int[][][] dp = new int[r][c][c];
//    for(int[][] g : dp){
//      for(int[] row : g){
//        Arrays.fill(row , -1);
//      }
//    }
//    return solve(0, 0, c - 1, grid , dp);
//  }

  public static void main(String[] args) {
    System.out.println(maximumChocolates(3, 4, new int[][]{
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5}
    }));
  }
}
