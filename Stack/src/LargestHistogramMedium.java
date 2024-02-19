import java.util.Arrays;
import java.util.Stack;

public class LargestHistogramMedium {

  public int largestRectangleArea(int[] heights) {
    int[] nsl = new int[heights.length];
    int[] nsr = new int[heights.length];
    Stack<Integer> stack = new Stack<>();

    // Calculating next smaller element on left
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nsl[i] = -1;
      } else {
        nsl[i] = stack.peek();
      }

      stack.push(i);
    }
    // Calculating next smaller element on right
    stack = new Stack<>();
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nsr[i] = heights.length;
      } else {
        nsr[i] = stack.peek();
      }
      stack.push(i);
    }

    int area = 0;
    for (int i = 0; i < heights.length; i++) {
      int h = heights[i];
      int w = nsr[i] - nsl[i] - 1;
      int currArea = h * w;
      area = Math.max(area, currArea);
    }

    return area;
  }

  public static void main(String[] args) {
    LargestHistogramMedium solver = new LargestHistogramMedium();
    System.out.println(solver.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
  }
}
