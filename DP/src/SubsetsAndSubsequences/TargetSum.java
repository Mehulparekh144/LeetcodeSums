package SubsetsAndSubsequences;

import java.util.Arrays;

public class TargetSum {


  // MEMOIZATION + RECURSION - Partition array for a difference
  int[][] dp;
  public int solveMemo(int i, int[] nums, int k) {
    if(i == 0){
      if(k == 0 && nums[0] == 0){
        return 2; // pick and notpick
      }
      if(k == 0 || nums[0] == k){
        return 1;
      }
      return 0;
    }

    if(dp[i][k] != -1) return dp[i][k];
    int np = solve(i-1 , nums , k);
    int p = 0;
    if(k >= nums[i]){
      p = solve(i-1 , nums , k - nums[i]);
    }
    dp[i][k] = p+np;
    return dp[i][k];
  }

  public int findTargetSumWaysMemo(int[] nums, int target) {

    int s = Arrays.stream(nums).sum(); // s
    if((s-target) < 0 || (s-target)%2 != 0 ){
      return 0 ;
    }
    dp = new int[nums.length][(s-target)/2+1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(nums.length - 1 , nums , (s-target)/2);
  }

  // RECURSION
  public int solve(int i , int[] nums , int target){
    if(i == nums.length){
      if(target == 0){
        return 1;
      }
      return 0;
    }

    int plus = solve(i+1 , nums , target - nums[i]);
    int minus = solve(i+1 , nums , target + nums[i]);
    return plus + minus;
  }
  public int findTargetSumWays(int[] nums, int target) {
    return solve(0 , nums ,  target);
  }

  public static void main(String[] args) {
    TargetSum obj = new TargetSum();
    System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1} , 3));
  }
}
