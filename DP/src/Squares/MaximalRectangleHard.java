package Squares;

import java.util.Stack;

public class MaximalRectangleHard {
  public int maximalRectangle(char[][] matrix) {
    int[] heights = new int[matrix[0].length];

    int maxi = Integer.MIN_VALUE;
    for(int i = 0 ; i < matrix.length ; i++){
      for(int j = 0 ; j < matrix[0].length ; j++){
        if(matrix[i][j] == '1'){
          heights[j] += 1;
        } else{
          heights[j] = 0;
        }
      }
      maxi = Math.max(maxi , largestArea(heights));
    }

    return maxi;
  }

  private int largestArea(int[] heights){
    Stack<Integer> st = new Stack<>();
    int maxArea = Integer.MIN_VALUE;

    for(int i = 0 ; i <= heights.length ; i++){
      while(!st.isEmpty() &&
              ( i == heights.length ||
                      heights[st.peek()] >= heights[i])){

        int height = heights[st.pop()];
        int width = i;
        if(!st.isEmpty()){
          width = i - st.peek() - 1;
        }
        int area = height*width;
        maxArea = Math.max(area , maxArea);
      }

      st.push(i);
    }

    return maxArea;
  }
}
