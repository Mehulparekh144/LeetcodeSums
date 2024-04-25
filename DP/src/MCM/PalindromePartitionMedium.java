package MCM;

public class PalindromePartitionMedium {

  //TABULATION
  public int minCutTab(String s) {
    dp = new int[s.length() + 1];

    for(int i = s.length() - 1 ; i >= 0 ; i--){
      int mini = Integer.MAX_VALUE;
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(i , j , s)) {
          int cuts = 1 + dp[j+1];
          if (cuts < mini)
            mini = cuts;
        }
      }
      dp[i] = mini;
    }

    return dp[0] - 1;
  }

  //RECURSION + MEMOIZATION
  int[] dp;
  private int solve(int i, String s) {
    if (i == s.length())
      return 0;
    if(dp[i] != -1) return dp[i];
    int mini = Integer.MAX_VALUE;
    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(i , j , s)) {
        int cuts = 1 + solve(j + 1, s);
        if (cuts < mini)
          mini = cuts;
      }

    }

    return dp[i] = mini;
  }

  private boolean isPalindrome(int i , int j ,String s) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public int minCut(String s) {
    int[] dp = new int[s.length() + 1];
    for(int i = s.length() - 1 ; i >= 0 ; i--){
      int mini = Integer.MAX_VALUE;
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(i , j , s)) {
          int cuts = 1 + dp[j+1];
          if (cuts < mini)
            mini = cuts;
        }
      }
      dp[i] = mini;
    }

    return dp[0] - 1;
  }


public static void main(String[] args) {
    PalindromePartitionMedium obj = new PalindromePartitionMedium();
    System.out.println(obj.minCut("aab"));
  }
}

