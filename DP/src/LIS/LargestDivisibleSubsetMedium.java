package LIS;
import java.util.*;

public class LargestDivisibleSubsetMedium {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int[] hash = new int[n];

    for (int i = 0; i < n; i++) {
      hash[i] = i;
      for (int prev = 0; prev < i; prev++) {
        if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
          dp[i] = 1 + dp[prev];
          hash[i] = prev;
        }
      }
    }

    int maxi = -1;
    int lastIdx = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] > maxi) {
        maxi = dp[i];
        lastIdx = i;
      }
    }

    List<Integer> result = new ArrayList<>();
    result.add(nums[lastIdx]);
    while (hash[lastIdx] != lastIdx) {
      lastIdx = hash[lastIdx];
      result.add(nums[lastIdx]);
    }

    return result;
  }
}
