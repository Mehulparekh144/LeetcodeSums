import java.util.Arrays;
import java.util.Stack;

public class EvalRPNMedium {

  public int evalRPN(String[] tokens) {
    String[] operands  = new String[]{"+" , "-" , "*" , "/"};
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if (Arrays.asList(operands).contains(tokens[i])) {
        String operator = tokens[i];
        int num2 = !stack.isEmpty() ? stack.pop() : 0;
        int num1 = !stack.isEmpty() ? stack.pop() : 0;
        int temp = 0;
        switch (operator) {
          case "+":
            temp = num1 + num2;
            break;

          case "-":
            temp = num1 - num2;
            break;

          case "*":
            temp = num1 * num2;
            break;

          case "/":
            temp = num1 / num2;
            break;
        }
        stack.add(temp);
      } else {
        stack.add(Integer.parseInt(tokens[i]));
      }
    }

    if (!stack.isEmpty()) {
      result = stack.pop();
    }

    return result;
  }

  public static void main(String[] args) {
    EvalRPNMedium solver = new EvalRPNMedium();
    String[] tokens = { "-11","10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
    System.out.println(solver.evalRPN(tokens));
  }
}