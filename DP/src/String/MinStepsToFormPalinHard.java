package String;

public class MinStepsToFormPalinHard {

  private int longestPalindromicSubSeq(String s){
    StringBuilder sb = new StringBuilder(s);
    String s2 = sb.reverse().toString();
    int n = s.length();
    int[] prev = new int[n+1];
    int[] curr = new int[n+1];
    for(int i2 = 0 ; i2 <= n ; i2++){
      prev[i2] = 0;
    }

    for(int i1 = 1 ; i1 <= n ; i1++){
      for(int i2 = 1 ; i2 <= n ; i2++){
        if(s.charAt(i1-1) == s2.charAt(i2-1)){
          curr[i2] = 1 + prev[i2-1];
        }
        else{
          curr[i2] = Math.max(prev[i2], curr[i2-1]);
        }
      }
      System.arraycopy(curr , 0 , prev , 0 , prev.length);
    }

    return prev[n];
  }
  public int minInsertions(String s) {
    return s.length() - longestPalindromicSubSeq(s);
  }
}
