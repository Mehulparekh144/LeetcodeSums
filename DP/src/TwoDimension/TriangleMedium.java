package TwoDimension;

import java.util.Arrays;
import java.util.List;

public class TriangleMedium {

  // Recursion
//  public int solve(int i , int j , List<List<Integer>> triangle){
//
//    if(i == triangle.size() - 1){
//      return triangle.get(i).get(j);
//    }
//    if(i < 0 || j < 0 || j > triangle.size() - 1 ){
//      return Integer.MAX_VALUE;
//    }
//    int straight = triangle.get(i).get(j) + solve(i+1 , j , triangle);
//    int diagonal = triangle.get(i).get(j) + solve(i+1 , j+1 , triangle);
//    return Math.min(straight , diagonal);
//
//  }
//  public int minimumTotal(List<List<Integer>> triangle) {
//    return solve(0 , 0 , triangle);
//  }

// Memoization
//  int[][] dp;
//  public int solve(int i , int j , List<List<Integer>> triangle){
//    if(i == triangle.size() - 1){
//      return triangle.get(i).get(j);
//    }
//    if(i < 0 || j < 0 || j > triangle.size() - 1 ){
//      return Integer.MAX_VALUE;
//    }
//    if(dp[i][j] != - 1){
//      return dp[i][j];
//    }
//    int straight = triangle.get(i).get(j) + solve(i+1 , j , triangle);
//    int diagonal = triangle.get(i).get(j) + solve(i+1 , j+1 , triangle);
//    dp[i][j] = Math.min(straight , diagonal);
//    return dp[i][j];
//  }
//  public int minimumTotalMemo(List<List<Integer>> triangle) {
//    int m = triangle.size();
//    int n = triangle.get(triangle.size() - 1).size();
//    dp = new int[m][n];
//    for(int[] row : dp){
//      Arrays.fill(row , -1);
//    }
//    return solve(0 , 0 , triangle);
//  }

  //TABULATION
//  int[][] dp;
//  public int minimumTotal(List<List<Integer>> triangle) {
//    int m = triangle.size();
//    int n = triangle.get(triangle.size() - 1).size();
//    dp = new int[m][n];
//    for(int[] row : dp){
//      Arrays.fill(row , -1);
//    }
//    for(int j = 0 ; j < n ; j++){
//      dp[m-1][j] = triangle.get(m-1).get(j);
//    }
//
//    for(int i = m-2 ; i >= 0; i--){
//      for(int j = i ; j >= 0 ; j--){
//        int straight = triangle.get(i).get(j) + dp[i+1][j];
//        int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
//        dp[i][j] = Math.min(straight, diagonal);
//      }
//    }
//    return dp[0][0];
//  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(triangle.size() - 1).size();
    int[] prev = new int[n];
    for(int j = 0; j < n; j++){
      prev[j] = triangle.get(m-1).get(j);
    }
    for(int i = m-2 ; i >= 0; i--){
      int[] temp = new int[n];
      for(int j = i ; j >= 0 ; j--){
        int straight = triangle.get(i).get(j) + prev[j];
        int diagonal = triangle.get(i).get(j) + prev[j+1];
        temp[j] = Math.min(straight, diagonal);
      }
      prev = temp;
    }
    return prev[0];
  }
}

