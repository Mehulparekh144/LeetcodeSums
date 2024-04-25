package MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloonHard {


  int[][] dp;
  private int burst(int i , int j , List<Integer> numsL){
    if(i > j) return 0;
    if(dp[i][j] != -1) return dp[i][j];
    int maxCoins = Integer.MIN_VALUE;
    for(int k = i ; k <= j ; k++){
      int coins = numsL.get(i-1)*numsL.get(k)*numsL.get(j+1) + burst(i , k-1 , numsL) + burst(k+1 , j , numsL);
      if(coins > maxCoins){
        maxCoins = coins;
      }
    }
    return dp[i][j] = maxCoins;
  }
  public int maxCoins(int[] nums) {
    dp = new int[nums.length + 2][nums.length + 2];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    List<Integer> numsL = new ArrayList<>();
    for(int num : nums){
      numsL.add(num);
    }
    numsL.add(1);
    numsL.add(0 , 1);
    return burst(1 , nums.length , numsL);
  }
}
