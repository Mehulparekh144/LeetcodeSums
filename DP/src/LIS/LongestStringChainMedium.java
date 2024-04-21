package LIS;
import java.util.*;
public class LongestStringChainMedium {

  public boolean isPredecessor(String s1 , String s2){
    if(s1.length() != s2.length() + 1) return false;
    int i = 0 ;
    int j = 0 ;

    while(i < s1.length()){
      if(j< s2.length() && s1.charAt(i) == s2.charAt(j)){
        i++;
        j++;
      } else{
        i++;
      }
    }

    return i == s1.length() && j == s2.length();
  }

  public int longestStrChain(String[] words) {
    Arrays.sort(words , (s1,s2) -> s1.length() - s2.length());
    System.out.println(Arrays.toString(words));
    int n = words.length;
    int[] dp = new int[n];
    Arrays.fill(dp , 1);
    int maxi = -1;

    for(int i = 0 ; i < n ;i++){
      for(int prev = 0 ; prev < i ; prev++){
        if(isPredecessor(words[i] , words[prev]) && 1 + dp[prev] > dp[i]){
          dp[i] = 1 + dp[prev];
        }
      }

      if(dp[i] > maxi) maxi = dp[i];
    }

    return maxi;
  }
}
