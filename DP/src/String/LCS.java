package String;

import java.util.Arrays;

public class LCS {
  //SPACE OPTIMIZATION
  public int longestCommonSubsequenceSO(String text1, String text2) {
    // Shifting of indices only for tabulation.
    int[]prev = new int[text2.length() + 1];
    int[]curr = new int[text2.length() + 1];

    // Omit this since there will be only 1 row;
    // for(int i = 0; i <= text1.length() ; i++){
    //     dp[i][0] = 0;
    // }

    for(int j = 0 ; j <= text2.length() ; j++){
      prev[j] = 0;
    }

    for(int i1 = 1 ; i1 <= text1.length() ; i1++){
      for(int i2 = 1 ; i2 <= text2.length() ; i2++){
        if(text1.charAt(i1-1) == text2.charAt(i2-1)){
          curr[i2] = 1 + prev[i2-1];
        }
        else{
          curr[i2] = Math.max(prev[i2] , curr[i2-1]);
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , curr.length);
    }

    return prev[text2.length()];

  }

  // TABULATION
  public int longestCommonSubsequenceTab(String text1, String text2) {
    // Shifting of indices only for tabulation.
    int[][]dp = new int[text1.length() + 1][text2.length() + 1];
    for(int i = 0; i <= text1.length() ; i++){
      dp[i][0] = 0;
    }

    for(int j = 0 ; j <= text2.length() ; j++){
      dp[0][j] = 0;
    }

    for(int i1 = 1 ; i1 <= text1.length() ; i1++){
      for(int i2 = 1 ; i2 <= text2.length() ; i2++){
        if(text1.charAt(i1-1) == text2.charAt(i2-1)){
          dp[i1][i2] = 1 + dp[i1-1][i2-1];
        }
        else{
          dp[i1][i2] = Math.max(dp[i1-1][i2] , dp[i1][i2-1]);
        }
      }
    }

    return dp[text1.length()][text2.length()];

  }

  // Shifting of Indices
  int[][] dp;
  private int solve2(String s1 , int i1 , String s2 , int i2){
    if(i1== 0 || i2 == 0){
      return 0;
    }

    if(dp[i1][i2] != -1){
      return dp[i1][i2];
    }

    // Shifting of indices i represents i-1;
    if(s1.charAt(i1-1) == s2.charAt(i2-1)){
      dp[i1][i2] =  1 + solve(s1 , i1-1 , s2 , i2-1);
      return dp[i1][i2];
    }

    return dp[i1][i2] = Math.max(solve(s1 , i1-1 , s2 , i2) , solve(s1 , i1 , s2 , i2-1));
  }

  public int longestCommonSubsequence2(String text1, String text2) {
    // Shifting of indices only for tabulation.
    dp = new int[text1.length() + 1][text2.length() + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve2(text1 , text1.length() , text2 , text2.length());

  }

  // RECURSION + MEMOIZATION

  private int solve(String s1 , int i1 , String s2 , int i2){
    if(i1 < 0 || i2 < 0){
      return 0;
    }

    if(dp[i1][i2] != -1){
      return dp[i1][i2];
    }

    if(s1.charAt(i1) == s2.charAt(i2)){
      dp[i1][i2] =  1 + solve(s1 , i1-1 , s2 , i2-1);
      return dp[i1][i2];
    }

    return dp[i1][i2] = Math.max(solve(s1 , i1-1 , s2 , i2) , solve(s1 , i1 , s2 , i2-1));
  }

  public int longestCommonSubsequence(String text1, String text2) {
    dp = new int[text1.length()][text2.length()];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(text1 , text1.length() - 1 , text2 , text2.length() - 1);

  }
}
