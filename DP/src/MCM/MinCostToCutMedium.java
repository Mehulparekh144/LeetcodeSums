package MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostToCutMedium {

  //TABULATION
  public int minCostTab(int n, int[] cuts) {
    int[][] dp = new int[cuts.length + 2][cuts.length  + 2];
    Arrays.sort(cuts);
    List<Integer> cutsL = new ArrayList<>();
    cutsL.add(0 , 0);
    for(int cut : cuts){
      cutsL.add(cut);
    }
    cutsL.add(n);
    System.out.println(cutsL);

    for(int i = cuts.length ; i >= 1 ; i--){
      for(int j = 1 ; j <= cuts.length ; j++){
        if(i > j) continue;
        int minCost = Integer.MAX_VALUE;
        for(int k = i ; k <= j ; k++){
          int cost = cutsL.get(j+1) - cutsL.get(i-1) + dp[i][k-1] + dp[k+1][j];
          minCost = Math.min(minCost , cost);
        }

        dp[i][j] = minCost;
      }
    }

    return dp[1][cuts.length];
  }

  //RECURSION + MEMOIZATION
  int[][] dp;
  private int solve(int i, int j, List<Integer> cuts) {
    if (i > j)
      return 0;
    if(dp[i][j] != -1) return dp[i][j];
    int minCost = Integer.MAX_VALUE;
    for(int k = i ; k <= j ; k++){
      int cost = cuts.get(j+1) - cuts.get(i-1) + solve(i , k-1 , cuts) + solve(k+1 , j , cuts);
      minCost = Math.min(minCost , cost);
    }

    return dp[i][j] = minCost;
  }

  public int minCost(int n, int[] cuts) {
    dp = new int[cuts.length + 1][cuts.length  + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    Arrays.sort(cuts);
    List<Integer> cutsL = new ArrayList<>();
    cutsL.add(0 , 0);
    for(int cut : cuts){
      cutsL.add(cut);
    }
    cutsL.add(n);
    return solve(1, cuts.length, cutsL);
  }
}
