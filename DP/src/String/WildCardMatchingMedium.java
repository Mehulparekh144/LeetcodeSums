package String;

import java.util.Arrays;

public class WildCardMatchingMedium {
  //SPACE OPTIMIZATION
  public boolean isMatchSO(String s, String p) {
    boolean[] prev = new boolean[p.length() + 1];
    boolean[] curr = new boolean[p.length() + 1];

    prev[0] = true;

    for(int j = 1 ; j < p.length() + 1 ; j++){
      if(p.charAt(j-1) == '*'){
        prev[j] = prev[j-1];
      }
    }

    for(int i = 1 ; i < s.length() + 1 ; i++){
      for(int j = 1 ; j < p.length() + 1 ; j++){
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
          curr[j] = prev[j-1];
        }

        else{
          if(p.charAt(j-1) == '*'){
            curr[j] = prev[j] || curr[j-1];
          } else{
            curr[j] = false;
          }
        }
      }

      System.arraycopy(curr , 0 , prev , 0 , curr.length);
    }

    return prev[p.length()];
  }

  //TABULATION
  public boolean isMatchTab(String s, String p) {

    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    dp[0][0] = true;

    for(int j = 1 ; j < p.length() + 1 ; j++){
      if(p.charAt(j-1) == '*'){ // If previous is also '*' then it will match but if previous is
        // false that means wildcard won't match it
        dp[0][j] = dp[0][j-1];
      }
    }

    for(int i = 1 ; i < s.length() + 1 ; i++){
      for(int j = 1 ; j < p.length() + 1 ; j++){
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
          dp[i][j] = dp[i-1][j-1];
        }

        else{
          if(p.charAt(j-1) == '*'){
            dp[i][j] = dp[i-1][j] || dp[i][j-1];
          }
        }
      }
    }

    return dp[s.length()][p.length()];
  }

  //RECURSION + MEMOIZATION
  int[][] dp;
  private boolean solve(String s, String p, int i, int j) {
    if (i < 0 && j < 0)
      return true;
    if (i < 0) {
      while (j >= 0 && p.charAt(j) == '*') {
        j--;
      }
      return j < 0;
    }
    if (j < 0)
      return false;

    if(dp[i][j] != -1){
      return dp[i][j] == 1;
    }

    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
      dp[i][j] = solve(s, p, i - 1, j - 1) ? 1 : 0;
    } else {
      if (p.charAt(j) == '*') {
        dp[i][j] = (solve(s, p, i - 1, j) || solve(s, p, i, j - 1) ? 1 : 0);
      }
    }

    return dp[i][j] == 1;
  }

  public boolean isMatch(String s, String p) {
    dp = new int[s.length()][p.length()];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(s, p, s.length() - 1, p.length() - 1);
  }
}
