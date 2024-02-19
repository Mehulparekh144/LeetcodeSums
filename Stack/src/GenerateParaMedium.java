import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Iterator;

public class GenerateParaMedium {
  void helper(int open , int closed , Stack stack , int n , List<String> result ){
    if(open == n && open == closed && closed == n){
      Iterator<Character> val = stack.iterator();
      String temp = "";
      while(val.hasNext()){
        temp += val.next();
      }
      result.add(temp);
      return;
    }
    if(open < n){
      stack.push("(");
      helper(open + 1 , closed , stack,n , result);
      stack.pop();
    }

    if(closed < open){
      stack.push(")");
      helper(open, closed + 1, stack, n, result);
      stack.pop();
    }
  }

  public List<String> generateParanthesis(int n) {
    Stack<Character> stack = new Stack<>();
    List<String> result = new ArrayList<>();
    helper(0, 0, stack, n, result);
    return result;
  }

  public static void main(String[] args) {
    GenerateParaMedium solver = new GenerateParaMedium();
    System.out.println(solver.generateParanthesis(3));
  }
}
