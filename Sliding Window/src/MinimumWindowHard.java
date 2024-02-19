import java.util.HashMap;

public class MinimumWindowHard {

  public String minWindow(String s, String t) {
    if (t.isEmpty()) {
      return "";
    }

    HashMap<Character, Integer> tmap = new HashMap<>();
    HashMap<Character, Integer> smap = new HashMap<>();
    int length = Integer.MAX_VALUE;
    int[] resultIndex = new int[] { -1, -1 };
    for (char c : t.toCharArray()) {
      tmap.put(c, tmap.getOrDefault(c, 0) + 1);
    }
    int have = 0;
    int need = tmap.size();
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      smap.put(c, smap.getOrDefault(c, 0) + 1);

      if (tmap.containsKey(c) && smap.get(c) == tmap.get(c)) {
        have += 1;
      }

      while (have == need) {
        if (r - l + 1 < length) {
          length = r - l + 1;
          resultIndex = new int[] { l, r };
        }
        char leftChar = s.charAt(l);
        smap.put(leftChar, smap.get(leftChar) - 1);
        if (tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
          have -= 1;
        }
        l += 1;
      }

    }

    return length != Integer.MAX_VALUE ? s.substring(resultIndex[0], resultIndex[1] + 1) : "";
  }

  public static void main(String[] args) {
    MinimumWindowHard solver = new MinimumWindowHard();
    System.out.println(solver.minWindow("ADOBECODEBANC", "ABC"));
  }
}
