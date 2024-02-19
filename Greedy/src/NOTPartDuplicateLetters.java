import java.util.Stack;

public class NOTPartDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    int[] occurence = new int[26];
    boolean[] visited = new boolean[26];
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < s.length(); i++) {
      occurence[s.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < s.length(); i++) {
      int curr = s.charAt(i) - 'a';
      if (visited[curr]) {
        continue;
      }
      while (stack.size() > 0 && curr < stack.peek() && i < occurence[stack.peek()]) {
        visited[stack.pop()] = false;
      }
      stack.push(curr);
      visited[curr] = true;
    }

    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      sb.append((char) (stack.pop() + 'a'));
    }

    return sb.reverse().toString();



  }

  public static void main(String[] args) {
    NOTPartDuplicateLetters solver = new NOTPartDuplicateLetters();
    System.out.println(solver.removeDuplicateLetters("bcabc"));
  }
}
