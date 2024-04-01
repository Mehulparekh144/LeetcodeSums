package SubsetsAndSubsequences;

import java.util.Arrays;

public class PartitionWithGivenDiffMedium {

  //SPACE OPTIMIZED
  public static int countPartitionsSpaceOpt(int n, int d, int[] arr) {
    // Write your code here.
    int s = Arrays.stream(arr).sum();
    if((s-d) < 0 || (s-d)%2 != 0){
      return 0;
    }
    int[] prev  = new int[(s-d)/2 + 1];
    int target = (s-d)/2;

    if(arr[0] == 0){
      prev[0] = 2;
    } else{
      prev[0] = 1;
    }
    if(arr[0] != 0 && arr[0] <= target){
      prev[arr[0]] = 1;
    }

    for(int i = 1 ; i < n ; i++){
      int[] curr = new int[target + 1];
      for(int k = 0 ; k <= target ; k++){
        int np = prev[k];
        int p = 0 ;
        if(k >= arr[i]){
          p = prev[k-arr[i]];
        }

        curr[k] =  (p + np)%((int) Math.pow(10,9) + 7);
      }
      prev = curr;
    }

    return prev[target];
  }

  //Tabulation
  public static int countPartitionsTabulized(int n, int d, int[] arr) {
    // Write your code here.
    int s = Arrays.stream(arr).sum();
    if((s-d) < 0 || (s-d)%2 != 0){
      return 0;
    }
    int[][] dp  = new int[arr.length][(s-d)/2 + 1];
    int target = (s-d)/2;

    if(arr[0] == 0){
      dp[0][0] = 2;
    } else{
      dp[0][0] = 1;
    }
    if(arr[0] != 0 && arr[0] <= target){
      dp[0][arr[0]] = 1;
    }

    for(int i = 1 ; i < n ; i++){
      for(int k = 0 ; k <= target ; k++){
        int np = dp[i-1][k];
        int p = 0 ;
        if(k >= arr[i]){
          p = dp[i-1][k-arr[i]];
        }

        dp[i][k] =  (p + np)%((int) Math.pow(10,9) + 7);
      }
    }

    return dp[n-1][target];
  }

  public static int solve(int i , int target , int[] arr , int[][] dp){
    if (i == 0) {
      if(arr[0] == 0 && target == 0){
        return 2; // Pick and not Pick
      }
      if(target == 0 || target == arr[i]){
        return 1;
      } else return 0;
    }

    if(dp[i][target] != -1){
      return dp[i][target];
    }

    int p = 0;
    if(arr[i] <= target){
      p = solve(i-1 , target - arr[i] , arr , dp);
    }
    int np = solve(i-1 , target , arr , dp);
    return dp[i][target] = (p + np)%((int) Math.pow(10,9) + 7);
  }
  public static int countPartitions(int n, int d, int[] arr) {
    // Write your code here.
    int s = Arrays.stream(arr).sum();
    if((s-d) < 0 || (s-d)%2 != 0){
      return 0;
    }
    int[][] dp  = new int[arr.length][(s-d)/2 + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);

    }
    int s1 = solve(arr.length - 1 , (s-d)/2 , arr , dp);
    return s1;
  }

  public static void main(String[] args) {
    System.out.println(countPartitions(4 , 3 , new int[]{5,2,5,1}));
    System.out.println(countPartitions(4 , 3 , new int[]{5,2,6,4}));
  }
}
