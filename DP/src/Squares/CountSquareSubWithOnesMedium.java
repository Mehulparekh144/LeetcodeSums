package Squares;

import java.util.Arrays;

public class CountSquareSubWithOnesMedium {

  public int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    System.arraycopy(matrix , 0 , dp , 0 , matrix.length);
    for(int i = 1 ; i < m ; i++){
      for(int j = 1 ; j < n ; j++){
        if(matrix[i][j] == 1){
          dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] , dp[i][j-1]));

        }
      }
    }

    return Arrays.stream(dp).flatMapToInt(Arrays::stream).sum();
  }
}
