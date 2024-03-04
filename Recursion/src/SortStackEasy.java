import java.util.Stack;

public class SortStackEasy {
  private void addToStack(Stack<Integer> s, Integer x) {
    if (s.isEmpty() || x > s.peek()) {
      s.push(x);
      return;
    }
    Integer temp = s.pop();
    addToStack(s, x);
    s.push(temp);
  }

  public Stack<Integer> sortStack(Stack<Integer> s) {
    Stack<Integer> s2 = new Stack<>();
    while (!s.isEmpty()) {
      Integer temp = s.pop();
      addToStack(s2, temp);
    }
    return s2;
  }

  public static void main(String[] args) {
    SortStackEasy obj = new SortStackEasy();
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(2);
    stack.push(8);
    stack.push(1);
    stack.push(3);

    Stack<Integer> sortedStack = obj.sortStack(stack);

    System.out.println("Sorted Stack:");
    while (!sortedStack.isEmpty()) {
      System.out.println(sortedStack.pop());
    }
  }

}
