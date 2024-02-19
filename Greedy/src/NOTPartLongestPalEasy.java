import java.util.HashSet;

public class NOTPartLongestPalEasy {
  
  public int longestPalindrome(String s){
    int length = 0;
    HashSet<Character> hset = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char character = s.charAt(i);

      if(hset.contains(character)){
        length += 2;
        hset.remove(character);
      }
      else{
        hset.add(character);
      }
    }

    if(!hset.isEmpty()){
      length += 1;
    }
    return length;
  }

  public static void main(String[] args) {
    NOTPartLongestPalEasy solver = new NOTPartLongestPalEasy();
    System.out.println(solver.longestPalindrome("abccccdd"));
  }
}
