package String;

public class LongestPalindromicSubsequence {

  //SPACE OPTIMIZATION
  public int longestPalindromeSubseqSO(String s) {
    StringBuilder sb = new StringBuilder(s);
    String s2 = sb.reverse().toString();
    int[] prev = new int[s.length() + 1];
    int[] curr = new int[s.length() + 1];

    for(int i2 = 0 ; i2 <= s.length() ; i2++){
      prev[i2] = 0;
    }

    for(int i1 = 1 ; i1 <= s.length() ; i1++){
      for(int i2 = 1 ; i2<= s.length() ; i2++){
        if(s.charAt(i1 - 1) == s2.charAt(i2 - 1)){
          curr[i2] = 1 + prev[i2-1];
        }
        else{
          curr[i2] = Math.max(prev[i2] , curr[i2-1]);
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , prev.length);
    }
    return prev[s.length()];
  }

  //TABULATION
  public int longestPalindromeSubseqTab(String s) {
    StringBuilder sb = new StringBuilder(s);
    String s2 = sb.reverse().toString();
    int[][] dp = new int[s.length() + 1][s.length() + 1];

    for(int i1 = 0 ; i1 <= s.length(); i1++){
      dp[i1][0] = 0;
    }
    for(int i2 = 0 ; i2 <= s.length() ; i2++){
      dp[0][i2] = 0;
    }

    for(int i1 = 1 ; i1 <= s.length() ; i1++){
      for(int i2 = 1 ; i2<= s.length() ; i2++){
        if(s.charAt(i1 - 1) == s2.charAt(i2 - 1)){
          dp[i1][i2] = 1 + dp[i1-1][i2-1];
        }
        else{
          dp[i1][i2] = Math.max(dp[i1-1][i2] , dp[i1][i2-1]);
        }
      }
    }
    return dp[s.length()][s.length()];
  }
  //RECURSION + MEMOIZATION
  int[][] dp;
  private int solve(String s1 , int i1 , String s2 , int i2){
    if(i1 < 0 || i2 < 0) return 0;
    if(dp[i1][i2] != -1) return dp[i1][i2];
    if(s1.charAt(i1) == s2.charAt(i2)){
      return dp[i1][i2] = 1 + solve(s1 , i1-1 , s2 , i2-1);
    }

    return dp[i1][i2] = Math.max(solve(s1 , i1-1 , s2 , i2) , solve(s1 , i1 , s2 , i2-1));

  }
  public int longestPalindromeSubseq(String s) {
    dp = new int[s.length()][s.length()];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    StringBuilder reversedS = new StringBuilder(s);
    reversedS.reverse();
    return solve(s , s.length() - 1 , reversedS.toString() , reversedS.length() - 1 );
  }
}
