package SubsetsAndSubsequences;

public class SubsetSumKMedium {

  // SPACE OPTIMIZATION
  public static boolean subsetSumToK2(int n, int k, int arr[]){
    // Write your code here.
    boolean[] prev = new boolean[k+1];
    boolean[] curr = new boolean[k+1];
    prev[0] = true;
    curr[0] = true;

    if(arr[0] <= k){
      prev[arr[0]] = true;
    }
    for(int i = 1 ; i < n ; i++){
      for(int target = 1 ; target <= k ; target++){
        boolean choose = false;
        if(target >= arr[i]){
          choose = prev[target - arr[i]];
        }
        boolean notChoose = prev[target];
        curr[target] = choose || notChoose;
      }
      System.arraycopy(curr, 0, prev, 0, curr.length);
    }
    return prev[k];
  }


  // TABULATION
  public static boolean subsetSumToK(int n, int k, int[] arr) {
    // Write your code here.
    boolean[][] dp = new boolean[n][k + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    if (arr[0] <= k) {
      dp[0][arr[0]] = true;
    }
    for (int i = 1; i < n; i++) {
      for (int target = 1; target <= k; target++) {
        boolean choose = false;
        if (target >= arr[i]) {
          choose = dp[i - 1][target - arr[i]];
        }
        boolean notChoose = dp[i - 1][target];
        dp[i][target] = choose || notChoose;
      }
    }
    return dp[n - 1][k];
  }
}

// MEMOIZATION
//  private static boolean solve(int i , int arr[] , int target , int[][] dp){
//    if(target == 0){
//      return true;
//    }
//    if(i == 0){
//      if(target == arr[i]){
//        return true;
//      }
//      return false;
//    }
//
//    if(dp[i][target] != -1 ){
//      return dp[i][target] == 0 ? false : true;
//    }
//
//    boolean choose = false;
//    if(target >= arr[i]){
//      choose = solve(i-1 , arr , target - arr[i] , dp);
//    }
//    boolean notChoose = solve(i-1 , arr , target , dp);
//    dp[i][target] =  choose || notChoose ? 1 : 0;
//    return choose || notChoose;
//
//  }
//  public static boolean subsetSumToK(int n, int k, int arr[]){
//    // Write your code here.
//    int[][] dp = new int[n][k+1];
//    for(int[] row : dp){
//      Arrays.fill(row , -1);
//    }
//    return solve(n-1, arr, k , dp);
//  }

// RECURSION
//  private static boolean solve(int i , int arr[] , int target){
//    if(target == 0){
//      return true;
//    }
//    if(i == 0){
//      if(target == arr[i]){
//        return true;
//      }
//      return false;
//    }
//    boolean choose = false;
//    if(target >= arr[i]){
//      choose = solve(i-1 , arr , target - arr[i]);
//    }
//    boolean notChoose = solve(i-1 , arr , target);
//    return choose || notChoose;
//
//
//  }
//  public static boolean subsetSumToK(int n, int k, int arr[]){
//    // Write your code here.
//    return solve(n-1, arr, k);
//  }

