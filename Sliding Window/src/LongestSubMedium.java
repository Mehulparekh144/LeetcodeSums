import java.util.HashMap;
import java.util.Map;

public class LongestSubMedium {

  public int lengthOfLongestSubstring(String s) {
    if(s.isEmpty()){
      return 0;
    }
    Map<Character , Integer> map = new HashMap<>();
    int l = 0;
    int length = Integer.MIN_VALUE;
    for (int r = 0; r < s.length(); r++) {
      if(map.containsKey(s.charAt(r))){
        l = Math.max(l , map.get(s.charAt(r)) + 1);
      }
      length = Math.max(length , r-l+1);
      map.put(s.charAt(r) , r);
    }

    return length;


  }
  public static void main(String[] args) {
    LongestSubMedium solver = new LongestSubMedium();
    System.out.println(solver.lengthOfLongestSubstring("abcabcbb"));
  }
}
