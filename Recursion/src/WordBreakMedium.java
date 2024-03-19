import java.util.Arrays;
import java.util.HashSet;
import java.util.List; // Add missing import statement
import java.util.Set;

public class WordBreakMedium {

  public boolean solve(int idx, String s, Set<String> wordDict) {
    if (idx == s.length()) {
      return true;
    }
    for (int i = idx + 1; i <= s.length(); i++) {
      if (wordDict.contains(s.substring(idx, i))  && solve(i, s, wordDict)) {
        return true;
      }
    }
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return solve(0, s, new HashSet<>(wordDict));
  }

  public static void main(String[] args) {

  }
}
