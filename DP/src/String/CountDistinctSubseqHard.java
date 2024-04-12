package String;
import java.util.Arrays;

public class CountDistinctSubseqHard {

  //SO with 1 Array
  public int numDistinctSO1Array(String s, String t) {
    int[] prev = new int[t.length() + 1];
    prev[0] = 1;

    for(int i = 1 ; i <= s.length() ; i++){
      //We reversed the second loop so that the prev[j] takes the value of previous iteration.
      for(int j = t.length() ; j >= 1 ; j--){
        if(s.charAt(i-1) == t.charAt(j-1)){
          prev[j] = prev[j] + prev[j-1];
        } else{
          prev[j] = prev[j];
        }
      }
    }

    return prev[t.length()];
  }

  //SPACE OPTIMIZATION
  public int numDistinctSO(String s, String t) {
    int[] prev = new int[t.length() + 1];
    int[] curr = new int[t.length() + 1];
    prev[0] = 1;
    curr[0] = 1;

    for(int i = 1 ; i <= s.length() ; i++){
      for(int j = 1 ; j <= t.length() ; j++){
        if(s.charAt(i-1) == t.charAt(j-1)){
          curr[j] = prev[j] + prev[j-1];
        } else{
          curr[j] = prev[j];
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , prev.length);
    }

    return prev[t.length()];
  }


  //TABULATION
  int[][] dp;
  public int numDistinctTab(String s, String t) {
    dp = new int[s.length() + 1][t.length() + 1];
    // Initializing the first column means , at end of t string, you ll have a subsequence.
    for(int i = 0 ; i <= s.length() ; i++){
      dp[i][0] = 1;
    }

    // Initialize first row with 0, that means at end of first string you don't match t have a zero
    // Left dp[0][0] because that means both have matched.
    for(int j = 1 ; j <= t.length() ; j++){
      dp[0][j] = 0;
    }

    for(int i = 1 ; i <= s.length() ; i++){
      for(int j = 1 ; j <= t.length() ; j++){
        if(s.charAt(i-1) == t.charAt(j-1)){
          dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]);
        } else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    return dp[s.length()][t.length()];
  }

  //RECURSION + MEMOIZATION


  public int solve(String s , String t , int i , int j ){
    if(j < 0) return 1; // This means we have covered all characters of j. Which means we found an answer
    if(i < 0) return 0; // This means we have exhausted i and didn't find a match.

    if(dp[i][j] != -1) return dp[i][j];

    if(s.charAt(i) == t.charAt(j)){
      return dp[i][j] = solve(s,t,i-1,j-1)  // Both go ahead
              +
              solve(s,t,i-1,j); // we don't consider and look for other character.
    }

    else{
      return dp[i][j] = solve(s,t,i-1,j);
    }
  }
  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length()][t.length()];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(s,t, s.length()-1 , t.length()-1);
  }
}
