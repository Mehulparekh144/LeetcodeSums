public class StringToATOIMedium {
  int total;

  public int myAtoi(String s) {
    total = 0;
    return solver(s, 0, false, false);

  }

  public int solver(String s, int idx, boolean isNegative, boolean isNumber) {
    if (idx == s.length())
      return 0;
    if (!isNumber) {
      if (Character.isWhitespace(s.charAt(idx))) {
        return solver(s, idx + 1, isNegative, isNumber);
      }
      if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
        isNegative = s.charAt(idx) == '-' ? true : false;
        return solver(s, idx + 1, isNegative, !isNumber);
      }
    }
    isNumber = true;
    char c = s.charAt(idx);
    if (c - '0' < 0 || c - '0' > 9)
      return 0;
    if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && c - '0' > 7) {
      return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    total = total * 10 + c - '0';
    int t = solver(s, idx + 1, isNegative, isNumber);
    if (t == 0) {
      t = isNegative ? -total : total;
    }
    ;
    return t;

  }

  public static void main(String[] args) {
    StringToATOIMedium atoi = new StringToATOIMedium();
    int result = atoi.myAtoi("+1");
    System.out.println(result);
  }

}
