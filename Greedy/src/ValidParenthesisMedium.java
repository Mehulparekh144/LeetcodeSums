public class ValidParenthesisMedium {

  public boolean checkValidString(String s) {
    int leftMin = 0;
    int leftMax = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') {
        leftMin++;
        leftMax++;
      } else if (c == ')') {
        leftMin--;
        leftMax--;
      } else {
        leftMin--; // * --> (
        leftMax++; // * --> )
      }

      if (leftMax < 0) {
        return false;
      }
      if (leftMin < 0) {
        leftMin = 0; // Even if leftMin is 0 and leftmax is +ve. 0 can be in the range of -ve and +ve
                     // and hence if returned false instead of resseting can upset a lot of test
                     // cases
      }
      
    }
    return leftMin == 0;
  }

  public static void main(String[] args) {
    ValidParenthesisMedium solver = new ValidParenthesisMedium();
    System.out.println(solver.checkValidString("(*)"));
  }
}
