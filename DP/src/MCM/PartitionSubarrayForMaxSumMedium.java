package MCM;

import java.util.Arrays;

public class PartitionSubarrayForMaxSumMedium {
  //TABULATION
  public int maxSumAfterPartitioningTab(int[] arr, int k) {
    int n = arr.length;
    int[] dp = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
      int maxSum = Integer.MIN_VALUE;
      for (int j = i; j < i + k && j < n; j++) {
        int sum = getSum(i, j, arr) + dp[j + 1];
        if (sum > maxSum)
          maxSum = sum;
      }
      dp[i] = maxSum;
    }

    return dp[0];
  }

  //RECURSION + MEMOIZATION
  int[] dp;
  private int solve(int i , int k , int[] arr){
    int n = arr.length;
    if(i == n) return 0;
    if(dp[i] != -1) return dp[i];
    int maxSum = Integer.MIN_VALUE;
    for(int j = i; j < i + k && j < n ; j++ ){
      int sum = getSum(i , j , arr) + solve(j+1 , k , arr);
      if(sum > maxSum) maxSum = sum;
    }

    return  dp[i] = maxSum;
  }

  private int getSum(int i , int j , int[] arr){
    int max = Integer.MIN_VALUE;
    for(int k = i ; k <= j ; k++){
      if(arr[k] > max ){
        max = arr[k];
      }
    }
    int sum = max * (j - i + 1);
    return sum;
  }

  public int maxSumAfterPartitioning(int[] arr, int k) {
    dp = new int[arr.length + 1];
    Arrays.fill(dp , -1);
    return solve(0 , k , arr);
  }


  public static void main(String[] args) {
    PartitionSubarrayForMaxSumMedium obj = new PartitionSubarrayForMaxSumMedium();
    System.out.println(obj.maxSumAfterPartitioning( new int[] {1,15,7,9,2,5,10}, 3));
  }
}
