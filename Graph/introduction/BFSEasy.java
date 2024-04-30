package introduction;
import java.util.*;

public class BFSEasy {
  public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    visited[0] = true;

    while(!q.isEmpty()){
      int node = q.poll();
      result.add(node);

      for(int parent : adj.get(node)){
        if(!visited[parent]){
          visited[parent] = true;
          q.offer(parent);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(bfsTraversal(6, Arrays.asList(
      Arrays.asList(1, 2),
      Arrays.asList(0, 3, 4),
      Arrays.asList(0, 5),
      Arrays.asList(1, 5),
      Arrays.asList(1),
      Arrays.asList(2, 3)
    )));
  }
}
