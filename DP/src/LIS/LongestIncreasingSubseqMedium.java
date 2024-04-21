package LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubseqMedium {


  public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
    int[] dp = new int[x];
    int[] hash = new int[x];
    for(int i = 0 ; i < x ; i++){
      for(int prev = 0 ; prev < i ; prev++){
        if(arr[prev] < arr[i]  && 1 + dp[prev] > dp[i]){
          dp[i] = 1 + dp[prev];
          hash[i] = prev;
        }
      }
    }

    int maxi = -1;
    int lastIdx = -1;
    for(int i = 0 ; i < arr.length ; i++){
      if(dp[i] > maxi){
        maxi = dp[i];
        lastIdx = i ;
      }
    }

    List<Integer> res = new ArrayList<>();
    res.add(arr[lastIdx]);
    while(hash[lastIdx] != lastIdx){
      lastIdx = hash[lastIdx];
      res.add(arr[lastIdx]);
    }

    return res;
  }

  //1D Array
  public int lengthOfLIS1d(int[] nums){
    int[] dp = new int[nums.length];
    Arrays.fill(dp , 1);
    for(int i = 0 ; i < nums.length ; i++){
      for(int prev = 0 ; prev < i ; prev++){
        if(nums[prev] < nums[i]){
          dp[i] = Math.max(dp[i] , 1 + dp[prev]);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  //SPACE OPTIMIZATION
  public int lengthOfLISSO(int[] nums) {
    int[] curr = new int[nums.length + 1];
    int[] next = new int[nums.length + 1];
    for(int i = nums.length - 1 ; i >= 0 ; i--){
      for(int prev = i - 1 ; prev >= -1 ; prev--){
        int p = 0;
        if(prev == -1 || nums[i] > nums[prev]){
          p = 1 + next[i + 1];
        }

        int np = next[prev + 1];

        curr[prev+1] = Math.max(p , np);
      }

      System.arraycopy(curr , 0 , next , 0 , curr.length);
    }

    return next[0];
  }

  //TABULATION
  public int lengthOfLISTab(int[] nums) {
    int[][]dp = new int[nums.length + 1][nums.length + 1];
    for(int i = nums.length - 1 ; i >= 0 ; i--){
      for(int prev = i - 1 ; prev >= -1 ; prev--){
        int p = 0;
        if(prev == -1 || nums[i] > nums[prev]){
          p = 1 + dp[i+1][i + 1];
        }

        int np = dp[i+1][prev + 1];

        dp[i][prev+1] = Math.max(p , np);
      }
    }

    return dp[0][0];
  }

  //MEMO + RECUR
  int[][]dp;
  private int solve(int i , int[] nums , int prev){
    if(i == nums.length){
      return 0;
    }

    if(dp[i][prev + 1] != -1){
      return dp[i][prev+1];
    }

    int p = 0;
    if(prev == -1 || nums[i] > nums[prev]){
      p = 1 + solve(i+1 , nums , i);
    }
    int np = solve(i+1 , nums , prev);
    return dp[i][prev + 1] =  Math.max(p , np);
  }
  public int lengthOfLIS(int[] nums) {
    dp = new int[nums.length][nums.length + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(0 , nums  , -1 );
  }


  public static void main(String[] args) {
    printingLongestIncreasingSubsequence(new int[]{5,4,11,1,16,8} , 6);
  }
}
