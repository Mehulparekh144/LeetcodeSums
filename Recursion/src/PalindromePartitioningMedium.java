import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningMedium {
  private List<List<String>> result;

  private boolean isPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  private void solve(int i, String s, List<String> temp) {
    if (i >= s.length()) {
      result.add(new ArrayList<>(temp));
    }

    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(s.substring(i, j + 1))) {
        temp.add(s.substring(i, j + 1));
        solve(j + 1, s, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    solve(0, s, temp);
    return result;
  }

  public static void main(String[] args) {
    PalindromePartitioningMedium obj = new PalindromePartitioningMedium();
    System.out.println(obj.partition("aab"));
  }
}
