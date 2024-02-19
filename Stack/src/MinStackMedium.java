import java.util.Stack;

public class MinStackMedium {
  
  Stack<Integer> stack , minStack;

  public MinStackMedium() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }

  public void push(int val) {
    stack.push(val);
    minStack.push(Math.min(val , !minStack.isEmpty() ? minStack.peek() : val));
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
