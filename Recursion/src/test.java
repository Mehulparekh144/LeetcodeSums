import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
  public String customSortString(String order, String s) {
    List<Character> sArray = new ArrayList<>();
    for (char c : s.toCharArray()) {
      sArray.add(c);
    }

    Character[] sArrayAsArray = sArray.toArray(new Character[0]);

    Arrays.sort(sArrayAsArray, (a, b) -> {
      int idxA = order.indexOf((int) a); // Fix for Problem 2
      int idxB = order.indexOf((int) b); // Fix for Problem 3
      return idxA - idxB;
    });

    StringBuilder sb = new StringBuilder();
    for (char c : sArrayAsArray) {
      sb.append(c);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    test obj = new test();
    System.out.println(obj.customSortString("cba", "abcd"));
  }

}
