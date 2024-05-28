import java.util.*;
public class MultiplyStringMedium {
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();

    int[] res = new int[n1 + n2 - 1];

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        int c1 = num1.charAt(i) - '0';
        int c2 = num2.charAt(j) - '0';
        int digit = c1 * c2;
        res[i + j] += digit;
      }
    }

    for (int i = res.length - 1; i > 0; i--) {
      res[i - 1] += res[i] / 10;
      res[i] %= 10;
    }

    StringBuilder sb = new StringBuilder();
    for(int num : res){
      sb.append(num);
    }
    return sb.toString().charAt(0) == '0' ? "0" : sb.toString();

  }

  public static void main(String[] args) {
    MultiplyStringMedium obj = new MultiplyStringMedium();
    obj.multiply("123", "456");
  }
}
