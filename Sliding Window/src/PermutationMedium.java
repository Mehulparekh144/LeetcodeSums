// import java.util.HashMap;
// import java.util.Map;

public class PermutationMedium {

  public boolean checkInclusion(String s1, String s2) {
    if(s1.length() > s2.length()){
      return false;
    }
    int[] s1Count = new int[26];
    int[] s2Count = new int[26];
    int matches = 0;

    for (int i = 0; i < s1.length(); i++) {
      s1Count[s1.charAt(i) - 'a'] += 1;
      s2Count[s2.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < 26; i++) {
      if(s1Count[i] == s2Count[i]){
        matches += 1;
      }
    }

    int l = 0;
    for (int r = s1.length(); r < s2.length(); r++) {
      if(matches == 26){
        return true;
      }
      int idx = s2.charAt(r) - 'a';
      s2Count[idx] += 1;
      if(s1Count[idx] == s2Count[idx]){
        matches ++;
      }
      else if(s1Count[idx] + 1 == s2Count[idx]){
        matches --;
      }

      idx = s2.charAt(l) - 'a';
      s2Count[idx] -= 1;
      if (s1Count[idx] == s2Count[idx]) {
        matches++;
      } else if (s1Count[idx] - 1 == s2Count[idx]) {
        matches--;
      }
      l++;
    }
    return matches == 26;
  }

  // BETTER
  //   if (s1.length() > s2.length()) {
  //     return false;
  //   }
  //   int i = 0;
  //   int j = s1.length() - 1;
  //   Map<Character, Integer> freq1 = countFreq(s1);
  //   Map<Character, Integer> freq2 = countFreq(s2.substring(0, j));

  //   while (j < s2.length()) {
  //     freq2.put(s2.charAt(j), freq2.getOrDefault(s2.charAt(j), 0) + 1);
  //     System.out.println(freq2);
  //     if (freq2.equals(freq1)) {
  //       return true;
  //     }
  //     freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0) - 1);
  //     if (freq2.get(s2.charAt(i)) == 0) {
  //       freq2.remove(s2.charAt(i));
  //     }
  //     i++;
  //     j++;
  //   }
  //   return false;
  // }

  // private HashMap<Character, Integer> countFreq(String s) {
  //   HashMap<Character, Integer> map = new HashMap<>();
  //   for (Character c : s.toCharArray()) {
  //     map.put(c, map.getOrDefault(c, 0) + 1);
  //   }
  //   return map;
  // }

  public static void main(String[] args) {
    PermutationMedium solver = new PermutationMedium();
    System.out.println(solver.checkInclusion("ab", "eidbaooo"));
  }
}
