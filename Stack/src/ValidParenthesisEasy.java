import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesisEasy {
  
  public boolean isValid(String s){
    Map<Character,Character> map = new HashMap<>();
    Stack<Character> stack = new Stack<>();
    map.put('(' , ')');
    map.put('[',']');
    map.put('{','}');

    for(char c : s.toCharArray()){
      if(map.containsKey(c)){
        stack.add(c);
      }
      else if(stack.isEmpty() || c != map.get(stack.pop())){
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    ValidParenthesisEasy solver = new ValidParenthesisEasy();
    System.out.println(solver.isValid("(([]}))"));
  }
}
