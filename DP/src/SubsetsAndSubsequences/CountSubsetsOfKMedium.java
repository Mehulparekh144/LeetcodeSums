package SubsetsAndSubsequences;

import java.util.Arrays;

public class CountSubsetsOfKMedium {

  public static int findWaysOptimized(int[] nums, int tar) {
    // Write your code here.
    int[][] dp = new int[nums.length][tar + 1];
    int[] prev = new int[tar + 1];

    if(nums[0] == 0){
      prev[0] = 2; // 2 case - np and pick
    }
    else prev[0] = 1;  // 1 case - not pick
    if(nums[0]!=0 && nums[0]<=tar) prev[nums[0]] = 1;

    for(int i = 1; i < nums.length ; i++){
      int[] curr = new int[tar + 1];
      for(int j = 0 ; j <= tar ; j++){
        int np = prev[j];
        int p = 0;
        if(j >= nums[i]){
          p = prev[j - nums[i]];
        }
        curr[j] = (np + p) % ((int) Math.pow(10,9) + 7);
      }
      prev = curr;
    }
    return prev[tar] ;
  }

  private static int solve(int i, int[] nums, int target, int[][] dp) {
    if (i == 0) {
      if(nums[0] == 0 && target == 0){
        return 2; // Pick and not Pick
      }
      if(target == 0 || target == nums[i]){
        return 1;
      } else return 0;
    }

    if (dp[i][target] != -1) {
      return dp[i][target];
    }

    int pick = 0;
    if (nums[i] <= target) {
      pick = solve(i - 1, nums, target - nums[i], dp);
    }
    int notPick = solve(i - 1, nums, target, dp);
    dp[i][target] = (pick + notPick) % ((int) Math.pow(10, 9) + 7);
    return dp[i][target];
  }

  public static int findWays(int[] num, int tar) {
    // Write your code here.
    int[][] dp = new int[num.length][tar + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return solve(num.length - 1, num, tar, dp);
  }

  public static void main(String[] args) {
    findWays(new int[]{1,1,4,5} , 3);
  }
}
