package SubsetsAndSubsequences;

import java.util.Arrays;

public class PartitionMinAbsoluteDifferenceHard{
  public int minimumDifference(int[] nums) {
    int target = Arrays.stream(nums).sum();
    boolean[][] dp = new boolean[nums.length][target + 1];
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }
    if (nums[0] <= target) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < nums.length; i++) {
      for (int j = 1; j <= target; j++) {
        boolean choose = false;
        if (j >= nums[i]) {
          choose = dp[i - 1][j - nums[i]];
        }
        boolean notChoose = dp[i - 1][j];
        dp[i][j] = choose || notChoose;
      }
    }

    int mini = (int) Math.pow(10, 9);
    for (int i = 0; i < target / 2; i++) {
      if (dp[nums.length - 1][i]) {
        int s2 = target - i;
        mini = Math.min(mini, Math.abs(i - s2));
      }
    }

    return mini;
  }
}
