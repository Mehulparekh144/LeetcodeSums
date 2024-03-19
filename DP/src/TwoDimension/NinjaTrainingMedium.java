package TwoDimension;

import java.util.Arrays;

public class NinjaTrainingMedium {


  //RECURSION
//  public static int solve(int day , int[][] points , int last){
//    if(day == 0){
//      int maxi = 0;
//      for (int i = 0; i <= 2; i++) {
//        if(i != last){
//          maxi = Math.max(maxi , points[0][i]);
//        }
//      }
//      return maxi;
//    }
//    int maxi= 0;
//    for (int i = 0; i <= 2; i++) {
//      if(i != last) {
//        int total = points[day][i] + solve(day - 1, points, i);
//        maxi = Math.max(maxi, total);
//      }
//    }
//    return maxi;
//  }
//  public static int ninjaTraining(int n, int[][] points) {
//    return solve(n - 1 , points , 3);
//  }


  // MEMOIZATION
//  public static int solve(int day, int[][] points, int last , int[][] dp) {
//    if (day == 0) {
//      int maxi = 0;
//      for (int i = 0; i <= 2; i++) {
//        if (i != last) {
//          maxi = Math.max(maxi, points[0][i]);
//        }
//      }
//      return maxi;
//    }
//    if(dp[day][last] != -1){
//      return dp[day][last];
//    }
//    int maxi = 0;
//    for (int i = 0; i <= 2; i++) {
//      if (i != last) {
//        int total = points[day][i] + solve(day - 1, points, i , dp);
//        maxi = Math.max(maxi, total);
//      }
//    }
//    dp[day][last] = maxi;
//    return dp[day][last];
//  }
//
//  public static int ninjaTraining(int n, int[][] points) {
//    int[][] dp = new int[n][4];
//    for(int[] row : dp){
//      Arrays.fill(row , -1);
//    }
//    return solve(n - 1, points, 3 , dp);
//  }

  // TABULATION
//  public static int ninjaTraining(int n , int[][] points){
//    int[][] dp = new int[n][4];
//    for(int[] row : dp){
//      Arrays.fill(row , -1);
//    }
//    dp[0][0] = Math.max(points[0][1] , points[0][2]);
//    dp[0][1] = Math.max(points[0][0] , points[0][2]);
//    dp[0][2] = Math.max(points[0][0] , points[0][1]);
//
//    for (int day = 1; day < n ; day++) {
//      for (int last = 0; last < 4; last++) {
//        dp[day][last] = 0;
//        int maxi = 0;
//        for (int i = 0; i < 3; i++) {
//          if(last != i){
//            int point = points[day][i] + dp[day-1][i];
//            maxi = Math.max(point , maxi);
//          }
//        }
//        dp[day][last] = maxi;
//      }
//    }
//    return dp[n-1][3];
//  }

  //TABULATION
  public static int ninjaTraining(int n , int[][] points){
    int[] prev = new int[4];
    Arrays.fill(prev , -1);
    prev[0] = Math.max(points[0][1] , points[0][2]);
    prev[1] = Math.max(points[0][0] , points[0][2]);
    prev[2] = Math.max(points[0][0] , points[0][1]);

    for (int day = 1; day < n ; day++) {
      int[] temp = new int[4];
      for (int last = 0; last < 4; last++) {
        for (int i = 0; i < 3; i++) {
          if(last != i){
            temp[last] = Math.max(points[day][i] + prev[i] , temp[last]);
          }
        }
      }
      prev = temp;
    }
    return prev[3];
  }

  public static void main(String[] args) {
    System.out.println(ninjaTraining(3,
            new int[][]{
                    {1, 2, 5},
                    {3, 1, 1},
                    {3, 3, 3}
            }));
  }
}
