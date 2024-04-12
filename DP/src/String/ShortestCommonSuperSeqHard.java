package String;

public class ShortestCommonSuperSeqHard {
  public String shortestCommonSupersequence(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int[][] dp = new int[n+1][m+1];
    for(int i1 = 0 ; i1 <= n ; i1++){
      dp[i1][0] = 0;
    }

    for(int i2 = 0 ; i2 <= m ; i2++){
      dp[0][i2] = 0;
    }

    for(int i1 = 1 ; i1 <= n ; i1++){
      for(int i2 = 1; i2 <= m ; i2++){
        if(str1.charAt(i1-1) == str2.charAt(i2-1)){
          dp[i1][i2] = 1 + dp[i1-1][i2-1];
        } else{
          dp[i1][i2] = Math.max(dp[i1-1][i2] , dp[i1][i2-1]);
        }
      }
    }

    int i1 = n;
    int i2 = m;
    StringBuilder ans = new StringBuilder();
    while(i1 > 0 && i2 > 0){
      if(str1.charAt(i1-1) == str2.charAt(i2-1)){
        ans.append(str1.charAt(i1-1));
        i1--;
        i2--;
      }

      else if(dp[i1-1][i2] > dp[i1][i2-1]){ // Upwards
        ans.append(str1.charAt(i1-1));
        i1--;
      }
      else{
        ans.append(str2.charAt(i2-1));
        i2--;
      }
    }

    while(i1>0){
      ans.append(str1.charAt(i1-1));
      i1--;
    }

    while(i2 > 0){
      ans.append(str2.charAt(i2-1));
      i2--;
    }

    return ans.reverse().toString();
  }
}
