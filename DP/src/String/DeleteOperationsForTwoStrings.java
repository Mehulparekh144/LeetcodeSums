package String;

import java.util.Arrays;

public class DeleteOperationsForTwoStrings {

  private int solve(String s1, String s2) {
    int[] prev = new int[s2.length() + 1];
    int[] curr = new int[s2.length() + 1];

    for (int i1 = 1; i1 < s1.length() + 1; i1++) {
      for (int i2 = 1; i2 < s2.length() + 1; i2++) {
        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
          curr[i2] = 1 + prev[i2 - 1];
        } else {
          curr[i2] = Math.max(prev[i2], curr[i2 - 1]);
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , prev.length);
    }

    return prev[s2.length()];

  }

  public int minDistanceSO(String word1, String word2) {
    int lcs = solve(word1, word2);
    int deletions = word1.length() - lcs;
    int insertions = word2.length() - lcs;
    return deletions + insertions;
  }

  //RECURSION + MEMOIZATION
  int[][] dp;
  private int solve(String s1 , int i1 , String s2 , int i2){
    if(i1 == 0 || i2 == 0) return 0;
    if(dp[i1][i2] != -1) return dp[i1][i2];
    if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
      return dp[i1][i2] = 1+ solve(s1 , i1-1 , s2 , i2-1);
    }

    return dp[i1][i2] = Math.max(solve(s1 , i1-1 , s2 , i2),
            solve(s1,i1,s2,i2-1));

  }

  public int minDistance(String word1, String word2) {
    dp = new int[word1.length() + 1][word2.length() + 1];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    int lcs = solve(word1 , word1.length() , word2 , word2.length());
    int deletions = word1.length() - lcs;
    int insertions = word2.length() - lcs;
    return deletions+insertions ;
  }
}

