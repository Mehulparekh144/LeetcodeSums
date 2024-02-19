import java.util.Stack;

public class DailyTempMedium {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] answers = new int[temperatures.length];
    int n = temperatures.length;
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
        stack.pop();
      }
      answers[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return answers;
  }

  public static void main(String[] args) {
    DailyTempMedium solver = new DailyTempMedium();
    for (int i : solver.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })) {
      System.out.println(i);
    }
  }
}
