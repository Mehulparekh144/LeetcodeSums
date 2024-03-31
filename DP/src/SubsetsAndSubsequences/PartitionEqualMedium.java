package SubsetsAndSubsequences;

import java.util.Arrays;

public class PartitionEqualMedium {

  // TABULATION
  boolean[][] dp;
  public boolean canPartition2(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    dp = new boolean[nums.length][target + 1];

    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }

    if (nums[0] <= target) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < nums.length; i++) {
      for (int k = 1; k <= target; k++) {
        boolean choose = false;
        if (nums[i] <= k) {
          choose = dp[i - 1][k - nums[i]];
        }
        boolean notChoose = dp[i - 1][k];
        dp[i][k] = choose || notChoose;
      }
    }

    return dp[nums.length - 1][target];
  }

  // MEMOIZATION
//  public boolean solve(int i, int[] nums, int target) {
//    if (target == 0) {
//      return true;
//    }
//
//    if (i == 0) {
//      return nums[i] == target;
//    }
//
//    if (dp[i][target] != -1) {
//      return dp[i][target] == 1;
//    }
//
//    boolean choose = false;
//    if (nums[i] >= target) {
//      choose = solve(i - 1, nums, target - nums[i]);
//    }
//    boolean notChoose = solve(i - 1, nums, target);
//    dp[i][target] = choose || notChoose ? 1 : 0;
//    return choose || notChoose;
//  }
//
//  public boolean canPartition(int[] nums) {
//    int sum = Arrays.stream(nums).sum();
//    if (sum % 2 != 0) {
//      return false;
//    }
//    int[][] dp = new int[nums.length][sum / 2 + 1];
//    for (int[] row : dp) {
//      Arrays.fill(row, -1);
//    }
//    return solve(nums.length - 1, nums, sum / 2);
//  }
}