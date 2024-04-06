package String;

public class LongestCommonSubstring {

  //Space Optimization
  public static int lcsSO(String str1, String str2){
    // Write your code here.
    int[] prev = new int[str2.length() + 1];
    int[] curr = new int[str2.length() + 1];

    int ans = Integer.MIN_VALUE;

    for(int i1 = 1; i1 <= str1.length() ; i1++){
      for(int i2 = 1; i2 <= str2.length() ; i2++){
        if(str1.charAt(i1-1) == str2.charAt(i2-1)){
          int val = 1 + prev[i2-1];
          curr[i2] = val;
          ans = Math.max(val , ans);
        }
        else{
          curr[i2] = 0;
        }
      }
      System.arraycopy(curr, 0, prev,  0, curr.length);
    }
    return ans;
  }


  //TABULATION
  public static int lcs(String str1, String str2){
    // Write your code here.
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    for(int i = 0 ; i < str1.length() + 1 ; i++){
      dp[i][0] = 0;
    }
    for(int j = 0 ; j < str2.length() + 1 ; j++){
      dp[0][j] = 0;
    }

    int ans = Integer.MIN_VALUE;

    for(int i1 = 1; i1 <= str1.length() ; i1++){
      for(int i2 = 1; i2 <= str2.length() ; i2++){
        if(str1.charAt(i1-1) == str2.charAt(i2-1)){
          int val = 1 + dp[i1-1][i2-1];
          dp[i1][i2] = val;
          ans = Math.max(val , ans);
        }
        else{
          dp[i1][i2] = 0;
        }
      }
    }
    return ans;
  }

}
