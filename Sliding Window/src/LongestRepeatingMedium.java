import java.util.Collections;
import java.util.HashMap;

public class LongestRepeatingMedium {

  public int characterReplacement(String s, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int l = 0;
    int result = 0;
    for (int r = 0; r < s.length(); r++) {
      map.put(s.charAt(r), 1 + map.getOrDefault(s.charAt(r), 0));
      while ((r - l + 1) - Collections.max(map.values()) > k) {
        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        l++;
      }
      result = Math.max(result, r - l + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    LongestRepeatingMedium solver = new LongestRepeatingMedium();
    System.out.println(solver.characterReplacement(
        "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));

  }
}
