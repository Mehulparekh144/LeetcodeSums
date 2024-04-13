package String;

import java.util.Arrays;

public class EditDistanceMedium {

  //SPACE OPTIMIZATION  
  public int minDistanceSO(String word1, String word2) {
    int[] prev = new int[word2.length() + 1];
    int[] curr = new int[word2.length() + 1];
    for(int j = 0 ; j <= word2.length() ; j++){
      prev[j] = j;
    }

    for(int i = 1 ; i <= word1.length() ; i++){
      curr[0] = i;
      for(int j = 1 ; j <= word2.length() ; j++){
        if(word1.charAt(i-1) == word2.charAt(j-1)){
          curr[j] = prev[j-1];
        }
        else{
          int replace = 1+ prev[j-1];
          int delete = 1+  prev[j];
          int add = 1+ curr[j-1];

          curr[j] = Math.min(Math.min(replace , delete) , add);
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , curr.length);
    }
    return prev[word2.length()];
  }

  //TABULATION
  public int minDistanceTab(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for(int i = 0 ; i <= word1.length() ; i++){
      dp[i][0] = i;
    }
    for(int j = 0 ; j <= word2.length() ; j++){
      dp[0][j] = j;
    }

    for(int i = 1 ; i <= word1.length() ; i++){
      for(int j = 1 ; j <= word2.length() ; j++){
        if(word1.charAt(i-1) == word2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }
        else{
          int replace = 1+ dp[i-1][j-1];
          int delete = 1+ dp[i-1][j];
          int add = 1+ dp[i][j-1];

          dp[i][j] = Math.min(Math.min(replace , delete) , add);
        }
      }
    }

    return dp[word1.length()][word2.length()];
  }


  //RECURSION + MEMOIZATION
    int[][] dp;
    public int solve(String s1 , String s2 , int i , int j){
      if(i < 0){
        return j+1; // If i is exhausted that means insertion operations can be done which will
        // be number of characters till j. i.e. j+1;
      }
      if(j < 0){
        return i+1; // If j is exhausted that means deletion operations can be done which will be
        // number of characters till i. i.e. i+1;
      }
      if(dp[i][j] != -1){
        return dp[i][j];
      }
      if(s1.charAt(i) == s2.charAt(j)){
        return dp[i][j] = solve(s1 , s2 , i-1 , j-1);
      }
      else{
        int replace = 1+ solve(s1 , s2 , i-1 , j-1);
        int delete = 1+ solve(s1, s2 ,  i-1 , j);
        int add = 1+ solve(s1, s2 , i ,  j-1);

        return dp[i][j] = Math.min(Math.min(replace , add) , delete);
      }
    }
    public int minDistance(String word1, String word2) {
      dp = new int[word1.length()][word2.length()];
      for(int[] row : dp){
        Arrays.fill(row ,-1);
      }
      return solve(word1 , word2 , word1.length() - 1, word2.length() - 1);
    }
}
